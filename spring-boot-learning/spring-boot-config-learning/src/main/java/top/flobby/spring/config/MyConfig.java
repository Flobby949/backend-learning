package top.flobby.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.flobby.spring.service.MyService;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description :
 * @create : 2023-03-14 15:05
 **/

@Configuration
public class MyConfig {

    /**
     * 将该方法的返回值作为bean，添加到Spring容器，Bean的id就是方法名
     *
     * @return {@link MyService}
     */
    @Bean
    public MyService myService() {
        return new MyService();
    }
}
