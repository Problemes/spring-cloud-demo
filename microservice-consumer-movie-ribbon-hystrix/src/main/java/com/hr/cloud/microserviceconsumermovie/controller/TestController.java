package com.hr.cloud.microserviceconsumermovie.controller;

import com.hr.cloud.microserviceconsumermovie.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by HR on 2018/10/9.
 */
@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/movie/{id}")
    //hystrixProperty参数execution.isolation.strategy=SEMAPHORE 是将HystrixCommand和此接口放到一个线程中，如果没有这个配置，是在不同线程执行的  建议在不出错的情况下不用配配置
    @HystrixCommand(fallbackMethod = "testControllerFallback", commandProperties = {@HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE")})
    public User testController(@PathVariable("id") Long id){
        return restTemplate.getForObject("http://MICROSERVICE-PROVIDER-USER/user/" + id, User.class);
    }

    // # /health.stream 开放的端口是检测api端口信息

    public User testControllerFallback(Long id){
        User user = new User();

        user.setId(-1l);
        user.setAge((short) 0);
        user.setName("fallback for failure");

        return user;
    }


}
