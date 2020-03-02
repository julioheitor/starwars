package b2w.project.starwars.persistence;

import b2w.project.starwars.model.Planet;

public interface PlanetDaoInterface extends DaoInterface<Planet>{

	Integer findNumberOfFilms(String id);
}
