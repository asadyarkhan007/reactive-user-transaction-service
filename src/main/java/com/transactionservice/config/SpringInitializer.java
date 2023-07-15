package com.transactionservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import java.nio.charset.StandardCharsets;

@Component
public class SpringInitializer implements CommandLineRunner {

	@Value("classpath:init.sql")
	Resource resource;


	@Autowired
	R2dbcEntityTemplate r2dbcEntityTemplate;

	@Override
	public void run(String... args) throws Exception {
		String content = StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);
		this.r2dbcEntityTemplate.getDatabaseClient().sql(content).then().subscribe();
	}
}
