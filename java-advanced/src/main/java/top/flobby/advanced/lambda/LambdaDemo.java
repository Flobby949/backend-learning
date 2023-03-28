package top.flobby.advanced.lambda;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author : Flobby
 * @program : java-advanced
 * @description : lambda练习
 * @create : 2023-03-29 00:07
 **/

public class LambdaDemo {
    public static void main(String[] args) {

    }

    public static void noArgumentNoReturn() {
        // 通过匿名内部类实例实例化一个 Runnable 接口的实现类
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {  // 方法无形参列表，也无返回值
                System.out.println("Hello, 匿名内部类");
            }
        };
        // 执行匿名内部类的 run() 方法
        runnable1.run();

        // 无参数无返回值，通过 lambda 表达式来实例化 Runnable 接口的实现类
        Runnable runnable2 = () -> System.out.println("Hello, Lambda");
        // 执行通过 lambda 表达式实例化的对象下的 run() 方法
        runnable2.run();
    }

    /**
     * 单参数无返回值
     */
    public static void oneArgumentNoReturn() {
        Consumer<String> consumer1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer1.accept("Hello World!");

        // 省略类型前代码
        Consumer<String> consumer2 = (String s) -> System.out.println(s);
        consumer2.accept("你好，世界！");

        // 省略类型后代码
        Consumer<String> consumer3 = (s) -> System.out.println(s);
        consumer3.accept("你好，世界！");
    }

    /**
     * 省略 return 和大括号
     */
    public static void noReturnCode() {
        // 省略 return 和 {} 前代码
        Comparator<Integer> comparator1 = (o1, o2) -> {
            return o1.compareTo(o2);
        };
        System.out.println(comparator1.compare(12, 12));

        // 省略 return 和 {} 后代码
        Comparator<Integer> comparator2 = (o1, o2) -> o1.compareTo(o2);
        System.out.println(comparator2.compare(12, 23));
    }
}
