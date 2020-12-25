package ru.geekbrains.spring.zuul.router.client;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

@Component
public class CustomZuulFilter extends ZuulFilter {

    @Value( "${zuul-router.server.port}")
    String fromPort;

    @Override
    public String filterType() {
        return FilterConstants. PRE_TYPE ;
    }

    @Override
    public int filterOrder() {
        return FilterConstants . DEBUG_FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext. getCurrentContext ();
        context . addZuulRequestHeader ( "fromPort" , fromPort );
        return null;
    }
}
