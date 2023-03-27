package top.flobby.spring.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
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
public class CommandLineStartupRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        log.info("CommandLineStartupRunner传入参数：{}", Arrays.toString(args));
    }
}