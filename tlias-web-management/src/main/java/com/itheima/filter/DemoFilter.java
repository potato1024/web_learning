package com.itheima.filter;

import javax.servlet.*;
import java.io.IOException;


//@WebFilter(urlPatterns = "/*")
public class DemoFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        System.out.println("init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("放行前");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("放行后");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
        System.out.println("destroy");
    }
}
