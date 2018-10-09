package com.hr.cloud.microserviceconsumermovie.controller;

import com.hr.cloud.microserviceconsumermovie.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
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
    public User testController(@PathVariable("id") Long id){
        return restTemplate.getForObject("http://localhost:7900/test/" + id, User.class);
    }
}
