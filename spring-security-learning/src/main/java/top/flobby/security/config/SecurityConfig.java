package top.flobby.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
                // 放行静态资源
                .requestMatchers(HttpMethod.GET,"/","/*.html","/css/*","/images/*")
                .permitAll()
                .and()
                // 对任意请求都进行认证
                // .anyRequest()
                // .authenticated()
                // .and()
                // 开启basic认证
                // .httpBasic();
                .formLogin()
                //加载自定义的登录页面地址
                .loginPage("/login")
                .permitAll()
                //登录成功后，是否始终跳转到登录成功url。默认为false
                .defaultSuccessUrl("/",true)
                //post登录接口，登录验证由系统实现
                .loginProcessingUrl("/login")
                //用户密码错误跳转接口
                .failureUrl("/error")
                //要认证的用户参数名，默认username
                .usernameParameter("username")
                //要认证的密码参数名，默认password
                .passwordParameter("password")
                .and()
                //配置注销
                .logout()
                //注销接口
                .logoutUrl("/logout")
                //注销成功后跳转到的接口
                .logoutSuccessUrl("/login")
                .permitAll()
                //删除自定义的cookie
                .deleteCookies("myCookie")
                .and()
                //注意:需禁用csrf防护功能,否则登录不成功
                .csrf()
                .disable();
        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
