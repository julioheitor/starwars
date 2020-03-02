package b2w.project.starwars.persistence;

import java.util.List;
import java.util.Optional;

import b2w.project.starwars.model.ModelObject;
import b2w.project.starwars.model.Planet;

public interface DaoInterface<T extends ModelObject>{

	Optional<T> save(T object);

	Optional<T> findById(String id);

	Optional<T> findByName(String name);

	List<T> findAll();

	Optional<Planet> delete(String id);
	
}
