package b2w.project.starwars.exceptions;

public class ModelObjectDoesNotExistsException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ModelObjectDoesNotExistsException(String message) {
		super(message);
	}

}
