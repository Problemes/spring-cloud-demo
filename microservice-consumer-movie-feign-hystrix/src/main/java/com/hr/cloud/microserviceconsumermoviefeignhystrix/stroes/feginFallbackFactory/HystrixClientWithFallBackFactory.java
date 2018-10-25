package com.hr.cloud.microserviceconsumermoviefeignhystrix.stroes.feginFallbackFactory;

import com.hr.cloud.microserviceconsumermoviefeignhystrix.stroes.StoreClient;
import org.springframework.stereotype.Component;

/**
 * Created by HR on 2018/10/24.
 */
@Component
public interface HystrixClientWithFallBackFactory extends StoreClient{
}
