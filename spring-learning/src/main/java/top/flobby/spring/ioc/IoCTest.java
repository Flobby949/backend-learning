package top.flobby.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : Flobby
 * @program : spring-learning
 * @description :
 * @create : 2023-03-06 14:53
 **/

public class IoCTest {
    public static void main(String[] args) {
        // 1. 配置文件路径
        String xmlPath = "/applicationContext.xml";
        // 2. 创建spring容器
        ApplicationContext ac = new ClassPathXmlApplicationContext(xmlPath);
        // 3. 从配置文件中读取配置好的bean
        UserDao userDao = (UserDao) ac.getBean("UserDao");
        userDao.say();
    }
}
