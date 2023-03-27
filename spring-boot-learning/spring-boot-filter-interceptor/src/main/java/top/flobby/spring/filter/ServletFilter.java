package top.flobby.spring.filter;

import jakarta.servlet.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description :
 * @create : 2023-03-27 14:49
 **/

@Slf4j
// @WebFilter("/servlet/*")
public class ServletFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("/servlet/* 过滤器生效");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("/servlet/* 过滤之前");
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("/servlet/* 过滤之后");

    }

    @Override
    public void destroy() {
        log.info("/servlet/* 过滤器销毁");
    }
}