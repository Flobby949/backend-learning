package top.flobby.spring.config;

import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.flobby.spring.interceptor.AuthInterceptor;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description : 拦截器配置类
 * @create : 2023-03-27 16:02
 **/

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Resource
    private AuthInterceptor authInterceptor;

    /**
     * 白名单url
     */
    private final String[] excludePaths = {"/images/**", "/css/**", "/*/index"};

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(excludePaths);
    }
}
