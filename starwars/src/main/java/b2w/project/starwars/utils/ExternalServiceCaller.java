package b2w.project.starwars.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ExternalServiceCaller {

	@Autowired
	private RestTemplate httpConnection;
	
	public String get(String url) {

		return httpConnection.getForObject(url, String.class);
	}

}
