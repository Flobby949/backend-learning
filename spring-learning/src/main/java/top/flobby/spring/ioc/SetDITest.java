package top.flobby.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : Flobby
 * @program : spring-learning
 * @description : setter 属性 依赖注入测试
 * @create : 2023-03-06 15:19
 **/

public class SetDITest {
    public static void main(String[] args) {
        String xmlPath = "/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(xmlPath);
        UserService userService = (UserService) ac.getBean("userService");
        userService.say();
    }
}
