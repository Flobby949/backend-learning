package top.flobby.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description :
 * @create : 2023-03-14 15:56
 **/

@Configuration
@Profile("dev")
public class DevConfig implements DBConfig{
    @Override
    public String sysProfile() {
        return "DEV环境";
    }
}
