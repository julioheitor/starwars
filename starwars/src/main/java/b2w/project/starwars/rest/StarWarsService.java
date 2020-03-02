package b2w.project.starwars.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import b2w.project.starwars.model.Planet;
import b2w.project.starwars.services.PlanetServiceInterface;

@RestController
@RequestMapping("/starwars")
public class StarWarsService {
	
	@Autowired
	private PlanetServiceInterface planetService;

	@GetMapping("/planet/all")
	public List<Planet> findAll() {

		return planetService.findAll();
	}

	@GetMapping("/planet/id/{id}")
	public Planet findById(@RequestParam String id) {
		
		return planetService.findById(id);
	}

	@GetMapping("/planet/name/{name}")
	public Planet findByName(@RequestParam String name) {
		
		return planetService.findByName(name);
	}

	@PostMapping("/planet")
	public Planet insertPlanet(@RequestBody Planet planet) {
		
		return planetService.insert(planet);
	}

	@DeleteMapping("/planet/{id}")
	public Planet deletePlanet(@RequestParam String id) {
		
		return planetService.delete(id);
	}
}
