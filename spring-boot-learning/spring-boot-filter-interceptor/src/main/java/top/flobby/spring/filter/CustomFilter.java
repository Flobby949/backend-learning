package top.flobby.spring.filter;

import jakarta.servlet.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description : 自定义过滤器
 * @create : 2023-03-27 14:44
 **/

@Slf4j
public class CustomFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("/api/* 过滤器生效");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("/api/* 过滤之前");
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("/api/* 过滤之后");

    }

    @Override
    public void destroy() {
        log.info("/api/* 过滤器销毁");
    }
}
