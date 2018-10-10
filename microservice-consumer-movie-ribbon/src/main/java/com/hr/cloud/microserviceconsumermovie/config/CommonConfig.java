package com.hr.cloud.microserviceconsumermovie.config;

import com.hr.cloud.microserviceconsumermovie.RibbonClientStrategyConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by HR on 2018/10/9.
 */
@Configuration
//@RibbonClient(name = "MICROSERVICE-PROVIDER-USER", configuration = RibbonClientStrategyConfiguration.class)
public class CommonConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
