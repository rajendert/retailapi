package target.retail.com.myretail.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RedskyServiceRestTemplateConfig {

	private RestTemplate redskyServiceTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getInterceptors().add((request, body, execution) -> {
			return execution.execute(request, body);
		});
		return restTemplate;
	}

	@Bean(name = "redskyApiRestTemplate")
	public RestTemplate createBean() {
		return redskyServiceTemplate();
	}

}
