package com.hr.cloud.microserviceconsumermovie;

import com.hr.cloud.microserviceconsumermovie.annotation.ExcludeComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = ExcludeComponentScan.class)})
public class MicroserviceConsumerMovieRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceConsumerMovieRibbonApplication.class, args);
	}
}
