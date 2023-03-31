package top.flobby.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author : Flobby
 * @program : spring-security-learning
 * @description : SecurityConfig 配置类
 * @create : 2023-03-31 12:43
 **/

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // 配置基本认证方式
        http.authorizeHttpRequests()
                // 对任意请求都进行认证
                .anyRequest()
                .authenticated()
                .and()
                //开启basic认证
                .httpBasic();
        return http.build();
    }
}
