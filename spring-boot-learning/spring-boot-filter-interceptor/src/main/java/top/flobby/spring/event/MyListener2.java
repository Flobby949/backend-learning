package top.flobby.spring.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description : 自定义事件监听器方式2：使用@Component注解将该类装载入spring容器中
 * @create : 2023-03-27 20:12
 **/

@Component
@Slf4j
public class MyListener2 implements ApplicationListener<MyEvent> {

    @Override
    public void onApplicationEvent(MyEvent event) {
        log.info(String.format("%s 监听到事件源：%s.", MyListener2.class.getName(), event.getSource()));
    }

}
