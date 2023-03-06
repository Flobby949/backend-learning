package top.flobby.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.flobby.spring.ioc.entity.*;

/**
 * @author : Flobby
 * @program : spring-learning
 * @description : Spring IoC 测试类
 * @create : 2023-03-06 14:53
 **/

public class IoCApplication {
    public static void main(String[] args) {
        // 1. 配置文件路径
        String xmlPath = "/applicationContext.xml";
        // 2. 创建spring容器
        ApplicationContext ac = new ClassPathXmlApplicationContext(xmlPath);

        personTest(ac);
    }

    public static void ioCTest(ApplicationContext ac) {
        // 3. 从配置文件中读取配置好的bean
        UserDao userDao = (UserDao) ac.getBean("userDao");
        userDao.say();
    }

    public static void setDITest(ApplicationContext ac) {
        UserService userService = (UserService) ac.getBean("userService");
        userService.say();
    }

    public static void animalTest(ApplicationContext ac) {
        Cat cat = (Cat) ac.getBean("cat");
        System.out.println(cat);
        Dog dog = (Dog) ac.getBean("dog");
        System.out.println(dog);
    }

    public static void bookTest(ApplicationContext ac) {
        Book bookConstructor = (Book) ac.getBean("bookConstructor");
        Book bookSet = (Book) ac.getBean("bookSet");
        System.out.println("通过带参构造方法创建");
        System.out.println(bookConstructor);
        System.out.println("通过默认构造方法创建");
        System.out.println(bookSet);
    }

    public static void personTest(ApplicationContext ac) {
        Person girl = ac.getBean("girl", Person.class);
        Person boy = ac.getBean("boy", Person.class);
        System.out.println(girl);
        System.out.println(boy);
    }

    public static void schoolBagTest(ApplicationContext ac) {
        SchoolBag schoolBag = ac.getBean("schoolBag", SchoolBag.class);
        System.out.println(schoolBag);
    }
}
