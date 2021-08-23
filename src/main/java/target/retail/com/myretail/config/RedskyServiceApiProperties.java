package target.retail.com.myretail.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Configuration
@ConfigurationProperties("redsky-api-properties")
@Getter
@Setter
public class RedskyServiceApiProperties {

	private String redSkyApiServiceUrl;

}
