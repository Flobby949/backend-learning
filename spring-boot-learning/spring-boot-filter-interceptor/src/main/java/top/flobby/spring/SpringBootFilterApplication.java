package top.flobby.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import top.flobby.spring.event.MyEvent;
import top.flobby.spring.event.MyListener1;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description : 启动类
 * @create : 2023-03-27 13:59
 **/

@SpringBootApplication
// @ServletComponentScan
public class SpringBootFilterApplication {
    public static void main(String[] args) {
        //获取ConfigurableApplicationContext上下文
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootFilterApplication.class, args);
        //装载监听
        context.addApplicationListener(new MyListener1());
        // 发布事件
        context.publishEvent(new MyEvent("测试事件"));
    }
}
