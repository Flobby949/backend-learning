package top.flobby.spring.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description : 应用启动的监听
 * @create : 2023-03-27 20:17
 **/

@Component
@Slf4j
public class AppStartupRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) {
        log.info("ApplicationRunner参数名称: {}", args.getOptionNames());
        log.info("ApplicationRunner参数值: {}", args.getOptionValues("age"));
        log.info("ApplicationRunner参数: {}", Arrays.toString(args.getSourceArgs()));
    }
}
