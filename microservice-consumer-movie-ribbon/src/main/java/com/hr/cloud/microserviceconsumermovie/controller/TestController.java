package com.hr.cloud.microserviceconsumermovie.controller;

import com.hr.cloud.microserviceconsumermovie.entity.User;
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

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/movie/{id}")
    public User testController(@PathVariable("id") Long id){
        return restTemplate.getForObject("http://MICROSERVICE-PROVIDER-USER/user/" + id, User.class);
    }

    @GetMapping("/testRibbonStrategy")
    public String testRibbonStrategy(){
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("MICROSERVICE-PROVIDER-USER"); //此处自定义随机策略 RandomRule
        ServiceInstance serviceInstance2 = this.loadBalancerClient.choose("MICROSERVICE-PROVIDER-USER2"); //此处默认轮询策略

        System.out.println("1:" + serviceInstance.getPort() + ":" + serviceInstance.getServiceId());
        System.out.println("2:" + serviceInstance2.getPort() + ":" + serviceInstance2.getServiceId());

        return "2";
    }


}
