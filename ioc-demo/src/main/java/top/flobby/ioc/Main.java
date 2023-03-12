package top.flobby.ioc;

import top.flobby.ioc.context.ApplicationContext;
import top.flobby.ioc.context.ClassPathXmlApplicationContext;
import top.flobby.ioc.entity.Apple;

/**
 * @author : Flobby
 * @program : ioc-demo
 * @description :
 * @create : 2023-03-12 11:52
 **/

public class Main {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext();
        Apple sweetApple = (Apple) ac.getBean("sweetApple");
        Apple sweetApple1 = (Apple) ac.getBean("sweetApple");
        System.out.println(sweetApple);
        System.out.println(sweetApple == sweetApple1);
    }
}
