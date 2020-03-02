package b2w.project.starwars.persistence;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import b2w.project.starwars.model.Planet;
import b2w.project.starwars.utils.ExternalServiceCaller;
import b2w.project.starwars.utils.IntegerNumbersUtils;
import b2w.project.starwars.utils.JsonUtils;

@Repository
public class PlanetDao implements PlanetDaoInterface {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private ExternalServiceCaller externalCaller;

	@Override
	public Optional<Planet> save(Planet planet) {

		Planet newPlanet = mongoTemplate.insert((Planet) planet);
		try {

			newPlanet.setStarwarsId(IntegerNumbersUtils.next());
			String result = externalCaller.get(
					"https://swapi.co/api/planets/" + newPlanet.getStarwarsId());
			newPlanet.setNumberOfFilms(JsonUtils.getFieldValueFromJsonString("films", result).size());

			mongoTemplate.save(newPlanet);
			return Optional.ofNullable(newPlanet);

		} catch (InterruptedException | ExecutionException e) {
			return Optional.ofNullable(newPlanet);
		}
	}

	@Override
	public Optional<Planet> findById(String id) {
		return Optional.ofNullable(mongoTemplate.findById(id, Planet.class));
	}

	@Override
	public Optional<Planet> findByName(String name) {

		Query query = new Query();
		query.addCriteria(Criteria.where("name").is(name));

		return Optional.ofNullable(mongoTemplate.find(query, Planet.class).get(0));
	}

	@Override
	public List<Planet> findAll() {
		return mongoTemplate.findAll(Planet.class);
	}

	@Override
	public Optional<Planet> delete(String id) {

		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(id));
		long deletedCount = mongoTemplate.remove(query, Planet.class).getDeletedCount();

		if (deletedCount == 0) {
			return Optional.ofNullable(null);
		}

		Planet planet = new Planet();
		planet.setId(id);
		return Optional.ofNullable(planet);
	}

	@Override
	public Integer findNumberOfFilms(String id) {
		
		Planet planet = mongoTemplate.findById(id, Planet.class);

		try {
			
			String result = "-1";
			if (planet != null) {
				result = externalCaller.get("https://swapi.co/api/planets/" + planet.getStarwarsId());
			}

			return JsonUtils.getFieldValueFromJsonString("films", result).size();
			
		} catch (InterruptedException | ExecutionException e) {
			return -1;
		}
	}

}
