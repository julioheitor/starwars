package b2w.project.starwars;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import b2w.project.starwars.model.Planet;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class StarwarsApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	
	@Test
	void putOnePlanetIntoDB() throws Exception {
		
		Planet planet = new Planet();
		planet.setName("Planet teste");
		planet.setWeather("weather");
		planet.setTerrain("terrain");
		
		mockMvc.perform( MockMvcRequestBuilders
			      .post("/starwars/planet")
			      .content(asJsonString(planet))
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk())
			      .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
	}
	
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	
	/**@AfterEach
	void clearDB() throws ModelObjectDoesNotExistsException {
		
		if(id == null) {
			return;
		}
		
		deletePlanetTransaction.setParameters(id);
		deletePlanetTransaction.execute();
	}
	
	
	
	@Test
	public void webLayerTest() throws Exception {
		this.mockMvc.perform(get("/starwars/planet/all")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	void insertPlanetTest() throws ModelObjectDoesNotExistsException {
		
		insertPlanetTransaction.setParameters("Planet name", "terrain", "weather");
		String planetId = insertPlanetTransaction.execute().getId();
		
		ModelObject planet = dao.findById(planetId);
		assertNotNull(planet, "Um planeta deveria ter sido obtido.");
		assertTrue(((Planet)planet).getNumberOfFilms() > 0);
		
		deletePlanetTransaction.setParameters(planetId);
		deletePlanetTransaction.execute();
	}

	
	@Test
	void findPlanetByIdTest() throws ModelObjectDoesNotExistsException {
		
		findByIdTransaction.setParameters(id);
		ModelObject planet = findByIdTransaction.execute();
		
		assertNotNull(planet, "Um planeta deveria ter sido obtido.");
	}
	
	@Test
	void findPlanetByNameTest() throws ModelObjectDoesNotExistsException {
		
		findByNameTransaction.setParameters("Planet teste");
		ModelObject planet = findByNameTransaction.execute();
		
		assertNotNull(planet, "Um planeta deveria ter sido obtido.");
	}
	
	@Test
	void findAllPlanetTest() throws ModelObjectDoesNotExistsException {
		
		findAllTransaction.execute();
		assertTrue(findAllTransaction.getPlanets().size() > 0);
	}
	
	@Test
	void deletePlanetTest() throws ModelObjectDoesNotExistsException {
		
		deletePlanetTransaction.setParameters(id);
		deletePlanetTransaction.execute();
		
		ModelObject planet = dao.findById(id);
		assertEquals(planet, null);
		id = null;
	}
	
	@Test
	void noPlanetExceptionTest() {
		
		findByIdTransaction.setParameters("-1");
		assertThrows(ModelObjectDoesNotExistsException.class, () -> findByIdTransaction.execute());
	}
**/
}
