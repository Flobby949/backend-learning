package top.flobby.advanced.method_ref;

import java.util.Comparator;
import java.util.function.Function;

/**
 * @author : Flobby
 * @program : java-advanced
 * @description : 方法引用
 * @create : 2023-03-29 00:24
 **/

public class MethodReferencesDemo {
    public static void main(String[] args) {
    }

    /**
     * 使用静态方法
     */
    public static void useStaticMethod() {
        // 使用 Lambda 表达式
        Comparator<Integer> comparator1 = (t1, t2) -> Integer.compare(t1, t2);
        System.out.println(comparator1.compare(11, 12));

        // 使用方法引用，类 :: 静态方法（ compare() 为静态方法）
        Comparator<Integer> comparator2 = Integer::compare;
        System.out.println(comparator2.compare(12, 11));

        // 使用 Lambda 表达式
        Function<Double, Long> function1 = d -> Math.round(d);
        Long apply1 = function1.apply(1.0);
        System.out.println(apply1);

        // 使用方法引用，类 :: 静态方法（ round() 为静态方法）
        Function<Double, Long> function2 = Math::round;
        Long apply2 = function2.apply(2.0);
        System.out.println(apply2);
    }

    /**
     * 使用类实例方法
     */
    public static void useClassInstanceMethod() {
        // 使用 Lambda 表达式
        Comparator<String> comparator1 = (s1, s2) -> s1.compareTo(s2);
        int compare1 = comparator1.compare("Hello", "Java");
        System.out.println(compare1);

        // 使用方法引用，类 :: 实例方法（ compareTo() 为实例方法）
        Comparator<String> comparator2 = String::compareTo;
        int compare2 = comparator2.compare("Hello", "Hello");
        System.out.println(compare2);
    }
}
