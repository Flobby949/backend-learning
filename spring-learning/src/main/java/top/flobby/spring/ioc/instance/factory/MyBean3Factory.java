package top.flobby.spring.ioc.instance.factory;

/**
 * @author : Flobby
 * @program : spring-learning
 * @description :
 * @create : 2023-03-06 14:49
 **/
public class MyBean3Factory {
    public MyBean3Factory() {
        System.out.println("Mybean3Factory的构造方法被调用了");
    }
    public Bean3 createBean3() {
        return new Bean3();
    }
}
