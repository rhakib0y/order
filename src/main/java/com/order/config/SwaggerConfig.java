package com.order.config;

import static springfox.documentation.builders.PathSelectors.regex;


import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket apiMain() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("MAIN").select()
				.apis(RequestHandlerSelectors.basePackage("com.order.controller")).paths(regex("/.*"))
				.build().apiInfo(metaInfo());
	}

	private ApiInfo metaInfo() {


		return new ApiInfo("APIs", "Resful API Documentaion", "1.0", "Terms of Service",
				new Contact("Rocky Chucas", "https://www.linkedin.com/in/rocky-chucas-551424b6/",
						StringUtils.EMPTY),
				"Apache License Version 2.0", "https://www.apache.org/licesen.html");
	}

}
