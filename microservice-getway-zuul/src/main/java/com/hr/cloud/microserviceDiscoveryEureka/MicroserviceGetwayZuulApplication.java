package com.hr.cloud.microserviceDiscoveryEureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class MicroserviceGetwayZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceGetwayZuulApplication.class, args);
	}
}
