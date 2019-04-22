/**
 * 
 */
package org.pk.springboot.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author PKCORP
 *
 */
@Component
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	/**
	 * @return Docklet
	 * @since v2
	 */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build().apiInfo(apiInfo()).enable(true).enableUrlTemplating(true);
	}

	private ApiInfo apiInfo() {
		@SuppressWarnings("deprecation")
		ApiInfo apiInfo = new ApiInfo("Spring Boot Rest API Application", "Some custom description of API.",
				"API POS", "Terms of service", "prvnpatil11@gmail.com", "License of API", "API license URL");
		return apiInfo;
	}
}