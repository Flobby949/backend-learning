package top.flobby.spring.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.Arrays;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description : 应用启动的监听
 * @create : 2023-03-27 20:17
 **/

@Configuration
@Slf4j
public class BeanRunner {
    @Bean
    @Order(1)
    public CommandLineRunner runner1() {
        return args -> log.info("BeanCommandLineRunner run1()" + Arrays.toString(args));
    }

    @Bean
    @Order(2)
    public CommandLineRunner runner2() {
        return args -> log.info("BeanCommandLineRunner run2()" + Arrays.toString(args));
    }

    @Bean
    @Order(3)
    public ApplicationRunner runner3() {
        return args -> log.info("BeanApplicationRunner run3()" + Arrays.toString(args.getSourceArgs()));
    }
}
