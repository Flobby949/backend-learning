package top.flobby.spring.ioc.instance.static_factory;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : Flobby
 * @program : spring-learning
 * @description :
 * @create : 2023-03-06 19:49
 **/
public class InstanceTest2 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");
        Bean2 bean2 = (Bean2) context.getBean("bean2");
        System.out.println(bean2);
    }
}
