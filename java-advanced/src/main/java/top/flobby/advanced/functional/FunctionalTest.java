package top.flobby.advanced.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author : Flobby
 * @program : java-advanced
 * @description : 函数式接口
 * @create : 2023-03-29 00:15
 **/

public class FunctionalTest {

    public static void main(String[] args) {

    }

    /**
     * 创建自定义函数式接口
     */
    public static void createCustom() {
        // 使用 Lambda 表达式方式创建函数式接口
        FunctionalInterfaceDemo functionalInterfaceDemo = () -> System.out.println("Lambda 表达式方式创建函数式接口");
        functionalInterfaceDemo.run();
    }

    /**
     * Java 内置4大核心函数式接口 —— 消费型接口
     */
    public static void consumerTest() {
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("只消费，不返回");
    }

    /**
     * Java 内置4大核心函数式接口 —— 供给型接口
     */
    public static void supplierTest() {
        Supplier<String> supplier = () -> "只返回，不消费";
        String s = supplier.get();
        System.out.println(s);
    }

    /**
     * Java 内置4大核心函数式接口 —— 断言型接口
     */
    public static void predicateTest() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Java");
        arrayList.add("PHP");
        arrayList.add("Python");
        arrayList.add("JavaScript");
        System.out.println("过滤前：");
        System.out.println(arrayList);

        List<String> filterResult = filterStringList(arrayList, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                // 返回字符串中是否包含 P
                return s.contains("P");
            }
        });

        // lambda
        // List<String> filterResult = filterStringList(arrayList, s -> s.contains("P"));

        System.out.println("过滤后：");
        System.out.println(filterResult);
    }

    public static List<String> filterStringList(List<String> list, Predicate<String> predicate) {
        // 过滤后的字符串列表
        ArrayList<String> arrayList = new ArrayList<>();
        for (String string: list) {
            if (predicate.test(string)) {
                // 如果 test 是 true，则将元素加入到过滤后的列表中
                arrayList.add(string);
            }
        }
        return arrayList;
    }
}
