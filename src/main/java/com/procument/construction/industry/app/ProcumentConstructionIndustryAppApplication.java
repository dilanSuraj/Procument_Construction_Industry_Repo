package com.procument.construction.industry.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.procument.construction.industry.app"})
@SpringBootApplication
@EnableAutoConfiguration
public class ProcumentConstructionIndustryAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProcumentConstructionIndustryAppApplication.class, args);
	}

}
