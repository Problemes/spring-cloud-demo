package com.hr.cloud.microserviceGetwayZuulRoute.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by HR on 2018/10/26.
 */
public class QueryParamPreFilter extends ZuulFilter {

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(QueryParamPreFilter.class);

    @Override
    public int filterOrder() {
        return 1; // run before PreDecoration
    }

    @Override
    public String filterType() {
        return "pre"; // pre, routing, post, error
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
//        return !ctx.containsKey("query_param") // a filter has already forwarded
//                && !ctx.containsKey("MICROSERVICE-PROVIDER-USER"); // a filter has already determined serviceId
        return true;
    }
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        if (request.getParameter("foo") != null) {
            // put the serviceId in `RequestContext`
            ctx.put("MICROSERVICE-PROVIDER-USER", request.getParameter("foo"));
        }

        logger.info("Zuul Filter pre Status Code zuul 过滤器: {}", ctx.getResponseStatusCode());

        return null;
    }
}
