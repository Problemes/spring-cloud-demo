package com.hr.cloud.microserviceconsumermovie;

import com.hr.cloud.microserviceconsumermovie.annotation.ExcludeComponentScan;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by HR on 2018/10/10.
 */
@Configuration
@ExcludeComponentScan
public class RibbonClientStrategyConfiguration {

    @Bean
    public IRule ribbonRule(){
        return new RandomRule();
    }
}
