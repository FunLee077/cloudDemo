package com.example.demo;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;


public class Filter extends ZuulFilter {

    private static Logger logger =LoggerFactory.getLogger(Filter.class);

    @Override
    public String filterType(){
        return "pre";
    }

    @Override
    public int filterOrder(){
        return 0;
    }

    @Override
    public boolean shouldFilter(){
        return true;
    }

    @Override
    public Object run(){
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        Object accessToken = request.getParameter("accessToken");
        if(accessToken == null){
            logger.warn("ERROR");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.setResponseBody("Error");
            return null;
        }
        logger.info("access token ok "+accessToken );
        ctx.setResponseBody("access token ok "+accessToken);
        return null;
    }

}
