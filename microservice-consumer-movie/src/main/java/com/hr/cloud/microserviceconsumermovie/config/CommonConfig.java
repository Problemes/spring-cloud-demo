package com.hr.cloud.microserviceconsumermovie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by HR on 2018/10/9.
 */
@Configuration
public class CommonConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
