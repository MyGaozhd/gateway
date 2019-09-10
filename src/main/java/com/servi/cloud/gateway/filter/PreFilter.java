package com.servi.cloud.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import sun.net.util.IPAddressUtil;

public class PreFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("PreFilter");
        RequestContext context = RequestContext.getCurrentContext();
        String ip = context.getRequest().getRemoteAddr();
        System.out.println("PreFilter:" + ip);
        context.setSendZuulResponse(false);
        context.setResponseBody("直接返回");
        context.getResponse().setContentType("application/json;charset=utf-8");
        System.out.println(1 / 0);
        return null;
    }
}
