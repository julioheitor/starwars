package b2w.project.starwars.services;

import b2w.project.starwars.model.Planet;

public interface PlanetServiceInterface extends Service<Planet>{

	Integer findNumberOfFilms(String Id);
}
