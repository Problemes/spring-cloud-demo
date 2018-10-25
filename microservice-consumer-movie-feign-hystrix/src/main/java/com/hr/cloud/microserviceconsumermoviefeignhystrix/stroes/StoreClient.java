package com.hr.cloud.microserviceconsumermoviefeignhystrix.stroes;

import com.hr.cloud.config.FooConfiguration;
import com.hr.cloud.microserviceconsumermoviefeignhystrix.entity.User;
import com.hr.cloud.microserviceconsumermoviefeignhystrix.stroes.feginFallbackFactory.HystrixClientFallbackFactory;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by HR on 2018/10/10.
 */
//@FeignClient(name = "MICROSERVICE-PROVIDER-USER", configuration = FooConfiguration.class, fallback = HystrixClientFallback.class) //使用自定义的FooConfiguration
//@FeignClient(name = "MICROSERVICE-PROVIDER-USER", fallbackFactory = HystrixClientFallbackFactory.class)
@FeignClient(name = "MICROSERVICE-PROVIDER-USER", fallback = HystrixClientFallback.class)
public interface StoreClient {

    //feign 此处不能用GetMapping 等组合注解; PathVariable 的路径参数必须完整不能省略; 当为传入的参数为复杂对象时，请求方法feign为默认为POST;
//    @RequestLine(value = "GET /user/{id}")
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    User testController(@PathVariable("id") Long id);

//    @RequestMapping(value = "/user/post", method = RequestMethod.POST)
//    User testPostUser(@RequestBody User user);

}


