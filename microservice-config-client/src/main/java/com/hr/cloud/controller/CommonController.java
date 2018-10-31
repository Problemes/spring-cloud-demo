package com.hr.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by HR on 2018/10/31.
 */
@RestController
public class CommonController {

    @Value("${profile}")
    private String profile;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return this.profile;
    }
}
