package top.flobby.spring.ioc.instance.static_factory;

/**
 * @author : Flobby
 * @program : spring-learning
 * @description :
 * @create : 2023-03-06 14:49
 **/
public class MyBean2Factory {
    public static Bean2 createBean2() {
        System.out.println("MyBean2Factory的静态方法被调用了");
        return new Bean2();
    }
}
