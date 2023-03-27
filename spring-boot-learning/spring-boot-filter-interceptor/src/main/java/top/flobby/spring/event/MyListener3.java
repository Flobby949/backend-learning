package top.flobby.spring.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description : 自定义事件监听器方式3：在application.yml中配置监听
 * @create : 2023-03-27 20:12
 **/

@Slf4j
public class MyListener3 implements ApplicationListener<MyEvent> {

    @Override
    public void onApplicationEvent(MyEvent event) {
        log.info(String.format("%s 监听到事件源：%s.", MyListener3.class.getName(), event.getSource()));
    }
}
