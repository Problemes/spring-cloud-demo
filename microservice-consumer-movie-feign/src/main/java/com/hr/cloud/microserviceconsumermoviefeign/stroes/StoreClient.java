package com.hr.cloud.microserviceconsumermoviefeign.stroes;

import com.hr.cloud.config.FooConfiguration;
import com.hr.cloud.microserviceconsumermoviefeign.entity.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by HR on 2018/10/10.
 */
@FeignClient(name = "MICROSERVICE-PROVIDER-USER", configuration = FooConfiguration.class) //使用自定义的FooConfiguration
public interface StoreClient {

    //feign 此处不能用GetMapping 等组合注解; PathVariable 的路径参数必须完整不能省略; 当为传入的参数为复杂对象时，请求方法feign为默认为POST;
    @RequestLine(value = "GET /user/{id}")
    User testController(@Param("id") Long id);

//    @RequestMapping(value = "/user/post", method = RequestMethod.POST)
//    User testPostUser(@RequestBody User user);
}


