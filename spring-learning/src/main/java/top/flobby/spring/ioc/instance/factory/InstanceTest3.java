package top.flobby.spring.ioc.instance.factory;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : Flobby
 * @program : spring-learning
 * @description :
 * @create : 2023-03-06 19:49
 **/
public class InstanceTest3 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans3.xml");
        Bean3 bean3 = (Bean3) context.getBean("bean3");
        System.out.println(bean3);
    }
}
