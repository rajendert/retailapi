package target.retail.com.myretail.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("target.retail.com.myretail.controller"))
				.paths(PathSelectors.any()).build().pathMapping("/products/*").apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().description("Target Retail App").title("retailapi").version("v1").build();
	}

	/*
	 * @Override public void addResourceHandlers(ResourceHandlerRegistry registry) {
	 * //enabling swagger-ui part for visual documentation
	 * registry.addResourceHandler("swagger-ui.html").addResourceLocations(
	 * "classpath:/META-INF/resources/");
	 * registry.addResourceHandler("/webjars/**").addResourceLocations(
	 * "classpath:/META-INF/resources/webjars/"); }
	 */

	/*
	 * private ApiInfo apiInfo() { return new ApiInfoBuilder()
	 * .title("Spring Boot REST API") .description("\"Target Retail App\"")
	 * .version("1.0.0") .license("Apache License Version 2.0")
	 * .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"") //.contact(new
	 * Contact("John Thompson", "http://springframework.guru/about/",
	 * "john@springfrmework.guru")) .build(); }
	 */

}
