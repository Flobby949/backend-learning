package top.flobby.spring.ioc.instance.constructor;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.flobby.spring.ioc.instance.constructor.Bean1;

/**
 * @author : Flobby
 * @program : spring-learning
 * @description :
 * @create : 2023-03-06 1:49
 **/

public class InstanceTest1 {
    public static void main(String[] args) {
        // 1. 配置文件目录
        String xmlPath="/beans1.xml";
        // 2.从配置文件中读取配置信息，创建对象 创建spring容器
        BeanFactory factory = new ClassPathXmlApplicationContext(xmlPath);
        // 3. 从容器中获取对象
        Bean1 bean1 = (Bean1) factory.getBean("bean1");
        // 4. 调用方法
        System.out.println(bean1);
    }
}
