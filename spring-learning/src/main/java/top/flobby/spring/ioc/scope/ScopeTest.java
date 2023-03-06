package top.flobby.spring.ioc.scope;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : Flobby
 * @program : spring-learning
 * @description :
 * @create : 2023-03-06 19:59
 **/
public class ScopeTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans4.xml");
        System.out.println(context.getBean("scope"));
        System.out.println(context.getBean("scope"));

        ClassPathXmlApplicationContext context1 = new ClassPathXmlApplicationContext("beans5.xml");
        System.out.println(context1.getBean("scope"));
    }
}
