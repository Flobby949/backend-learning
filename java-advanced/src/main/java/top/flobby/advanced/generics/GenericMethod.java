package top.flobby.advanced.generics;

/**
 * @author : Flobby
 * @program : java-advanced
 * @description : 泛型方法
 * @create : 2023-03-22 14:10
 **/

public class GenericMethod {

    /**
     * 泛型方法show
     *
     * @param t   要打印的参数
     * @param <T> T
     */
    public <T> void show(T t) {
        System.out.println(t);
    }

    public static void main(String[] args) {
        // 实例化对象
        GenericMethod genericMethod = new GenericMethod();
        // 调用泛型方法show，传入不同类型的参数
        genericMethod.show("Java");
        genericMethod.show(222);
        genericMethod.show(222.0);
        genericMethod.show(222L);
    }

}
