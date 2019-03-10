package com.ayaz.assessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static springfox.documentation.builders.PathSelectors.any;

@SpringBootApplication
@EnableSwagger2
public class UserauthserviceApplication {


	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.ayaz.assessment")).paths(any()).build()
				.apiInfo(new ApiInfo("Explore Auth API's",
						"API's for the Explore User Auth Service", "1.0", null,
						new Contact("Ayaz Ahmed Kuthus","", ""),
						null, null, new ArrayList()));
	}

	public static void main(String[] args) {
		SpringApplication.run(UserauthserviceApplication.class, args);
	}

}
