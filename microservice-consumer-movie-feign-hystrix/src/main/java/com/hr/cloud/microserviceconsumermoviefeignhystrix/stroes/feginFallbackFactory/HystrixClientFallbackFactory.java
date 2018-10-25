package com.hr.cloud.microserviceconsumermoviefeignhystrix.stroes.feginFallbackFactory;

import com.hr.cloud.microserviceconsumermoviefeignhystrix.entity.User;
import com.hr.cloud.microserviceconsumermoviefeignhystrix.stroes.StoreClient;
import feign.Param;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by HR on 2018/10/24.
 */
@Component
public class HystrixClientFallbackFactory implements FallbackFactory<StoreClient> {

    private final static Logger log = LoggerFactory.getLogger(HystrixClientFallbackFactory.class);

    @Override
    public StoreClient create(Throwable throwable) {

        log.info("fallback; reason was:============================================ {}", throwable.getMessage());

        return new HystrixClientWithFallBackFactory() {

            @Override
            public User testController(@Param("id") Long id) {

                User user = new User();
                user.setName("sb-fallback-factory");
                user.setId(-1l);

                return user;
            }
        };

    }
}
