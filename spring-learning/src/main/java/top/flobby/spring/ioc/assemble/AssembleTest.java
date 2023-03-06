package top.flobby.spring.ioc.assemble;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : Flobby
 * @program : spring-learning
 * @description :
 * @create : 2023-03-06 14:49
 **/
public class AssembleTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans6.xml");
        System.out.println(context.getBean("user1"));
        System.out.println(context.getBean("user2"));
    }
}
