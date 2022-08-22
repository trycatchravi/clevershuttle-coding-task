package com.org.clevershuttlecodingtask.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenDocApiConfig {

	private static final Log logs = LogFactory.getLog("OpenDocApiConfig");

	@Bean
	public OpenAPI docConfig() {
		return new OpenAPI().components(new Components())
				.info(new Info().title("CleverShuttle coding task - Car Service")
				.description("CleverShuttle coding task, Car API REST Documentation"));
	}

}
