package top.flobby.spring.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description : 自定义事件:继承ApplicationEvent抽象类，并定义自己的构造器
 * @create : 2023-03-27 20:04
 **/

public class MyEvent extends ApplicationEvent {

    public MyEvent(Object source) {
        super(source);
    }
}
