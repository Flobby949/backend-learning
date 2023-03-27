package top.flobby.spring.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.Collections;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description : filter bean 配置
 * @create : 2023-03-27 14:49
 **/

// @Configuration
public class FilterRegisterBean {

    /**
     * 在 Spring 中通过 bean 注册 filter
     * @return FilterRegistrationBean
     */
    @Bean
    public FilterRegistrationBean<CustomFilter> filterRegistrationBean(){
        FilterRegistrationBean<CustomFilter> filter = new FilterRegistrationBean<>();
        filter.setFilter(new CustomFilter());
        filter.setUrlPatterns(Collections.singleton("/api/*"));
        filter.setOrder(10);
        return filter;
    }
}
