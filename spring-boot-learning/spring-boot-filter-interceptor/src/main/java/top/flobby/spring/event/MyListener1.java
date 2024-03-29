package top.flobby.spring.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description : 自定义事件监听器方式1：实现ApplicationListener接口
 * @create : 2023-03-27 20:04
 **/

@Slf4j
public class MyListener1 implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent event) {
        log.info(String.format("%s 监听到事件源：%s.", MyListener1.class.getName(), event.getSource()));
    }
}
