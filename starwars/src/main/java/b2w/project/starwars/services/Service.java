package b2w.project.starwars.services;

import java.util.List;

import b2w.project.starwars.model.ModelObject;

public interface Service<T extends ModelObject> {

	T findById(String id);
	T findByName(String name);
	List<T> findAll();
	T insert(T object);
	T delete(String id);
	
}
