package b2w.project.starwars.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import b2w.project.starwars.exceptions.ModelObjectDoesNotExistsException;
import b2w.project.starwars.model.Planet;
import b2w.project.starwars.persistence.PlanetDaoInterface;

@Service
public class PlanetService implements PlanetServiceInterface {

	@Autowired
	private PlanetDaoInterface dao;
	
	@Override
	public Planet findById(String id) {
		return dao.findById(id).orElseThrow(() -> new ModelObjectDoesNotExistsException("O planeta não existe!"));
	}

	@Override
	public Planet findByName(String name) {
		return dao.findByName(name).orElseThrow(() -> new ModelObjectDoesNotExistsException("O planeta não existe!"));
	}

	@Override
	public List<Planet> findAll() {
		
		List<Planet> planets = dao.findAll();
		if(planets.size() > 0) return planets;
		throw new ModelObjectDoesNotExistsException("Não há planetas na base!");
	}

	@Override
	public Planet insert(Planet planet) {
		return dao.save(planet).orElseThrow(() -> new ModelObjectDoesNotExistsException("O planeta não existe!"));
	}

	@Override
	public Planet delete(String id) {
		return dao.delete(id).orElseThrow(() -> new ModelObjectDoesNotExistsException("O planeta não existe!"));
	}

	@Override
	public Integer findNumberOfFilms(String id) {
		return dao.findNumberOfFilms(id);
	}


}
