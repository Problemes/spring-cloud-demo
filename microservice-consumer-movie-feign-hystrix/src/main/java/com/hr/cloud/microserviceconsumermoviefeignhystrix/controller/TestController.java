package com.hr.cloud.microserviceconsumermoviefeignhystrix.controller;

import com.hr.cloud.microserviceconsumermoviefeignhystrix.entity.User;
import com.hr.cloud.microserviceconsumermoviefeignhystrix.stroes.StoreClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by HR on 2018/10/9.
 */
@RestController
public class TestController {

    @Autowired
    StoreClient storeClient;

    @GetMapping("/movie/{id}")
//    @HystrixCommand(fallbackMethod = "testOtherControllerFallback")
    public User testController(@PathVariable("id") Long id){
        return storeClient.testController(id);
    }

//    public User testOtherControllerFallback(Long id){
//
//        User user = new User();
//        user.setName("sb");
//        user.setId(-1l);
//
//        return user;
//    }

//    @PostMapping("/user/post")
//    public User testPostUser(@RequestBody User user){
//        return storeClient.testPostUser(user);
//    }

}
