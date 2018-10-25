package com.hr.cloud.microserviceconsumermoviefeignhystrix.stroes;

import com.hr.cloud.microserviceconsumermoviefeignhystrix.entity.User;
import feign.Param;
import org.springframework.stereotype.Component;

/**
 * Created by HR on 2018/10/24.
 */
@Component
public class HystrixClientFallback implements StoreClient {

    @Override
    public User testController(@Param("id") Long id) {

        User user = new User();
        user.setName("sb-feign-hystrix");
        user.setId(-1l);

        return user;
    }
}
