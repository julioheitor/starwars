package b2w.project.starwars.model;

public class Planet extends ModelObject{

	private String weather;
	private String terrain;
	
	private Integer numberOfFilms;
	private Integer starwarsId;
	
	public Planet() {
		
	}
	
	public Planet(String name, String weather, String terrain) {
		
		super();
		setName(name);
		this.weather = weather;
		this.terrain = terrain;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public String getTerrain() {
		return terrain;
	}

	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}

	public Integer getNumberOfFilms() {
		return numberOfFilms;
	}

	public void setNumberOfFilms(Integer numberOfFilms) {
		this.numberOfFilms = numberOfFilms;
	}
	
	@Override
	  public String toString() {
	    return String.format(
	        "Planet[id=%s, name='%s', weather='%s', terrain='%s']",
	        getId(), getName(), getWeather(), getTerrain());
	  }

	public Integer getStarwarsId() {
		return starwarsId;
	}

	public void setStarwarsId(Integer starwarsId) {
		this.starwarsId = starwarsId;
	}

	
}
