package com.hr.cloud.microserviceconsumermoviefeignhystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker
@EnableHystrixDashboard
public class MicroserviceConsumerMovieFeignHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceConsumerMovieFeignHystrixApplication.class, args);
	}
}
