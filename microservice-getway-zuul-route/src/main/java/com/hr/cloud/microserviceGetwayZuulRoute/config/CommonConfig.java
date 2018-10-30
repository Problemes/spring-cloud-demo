package com.hr.cloud.microserviceGetwayZuulRoute.config;

import com.hr.cloud.microserviceGetwayZuulRoute.filter.QueryParamPreFilter;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by HR on 2018/10/26.
 */
@Configuration
public class CommonConfig {

    @Bean //eureka 实例的名称正则转换 name-version ==> version/name 路径
    public PatternServiceRouteMapper serviceRouteMapper() {
        return new PatternServiceRouteMapper(
                "(?<name>^.+)-(?<version>v.+$)",
                "${version}/${name}");
    }

    @Bean //zuul 过滤器
    public QueryParamPreFilter queryParamPreFilter(){
        return new QueryParamPreFilter();
    }
}
