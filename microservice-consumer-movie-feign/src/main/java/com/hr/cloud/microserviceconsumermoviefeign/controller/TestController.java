package com.hr.cloud.microserviceconsumermoviefeign.controller;

import com.hr.cloud.microserviceconsumermoviefeign.entity.User;
import com.hr.cloud.microserviceconsumermoviefeign.stroes.StoreClient;
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
    public User testController(@PathVariable("id") Long id){
        return storeClient.testController(id);
    }

//    @PostMapping("/user/post")
//    public User testPostUser(@RequestBody User user){
//        return storeClient.testPostUser(user);
//    }
}
