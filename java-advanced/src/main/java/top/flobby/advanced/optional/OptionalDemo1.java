package top.flobby.advanced.optional;

import java.util.Optional;

/**
 * @author : Flobby
 * @program : java-advanced
 * @description :
 * @create : 2023-03-29 00:46
 **/

public class OptionalDemo1 {
    public static void main(String[] args) {
        // 创建一个 StringBuilder 对象
        StringBuilder string = new StringBuilder("我是一个字符串");

        // 使用 Optional.of(T t) 方法，创建 Optional 对象，注意 T 不能为空：
        Optional<StringBuilder> stringBuilderOptional = Optional.of(string);
        System.out.println(stringBuilderOptional);

        // 使用 Optional.empty() 方法，创建一个空的 Optional 对象：
        Optional<Object> empty = Optional.empty();
        System.out.println(empty);

        // 使用 Optional.ofNullable(T t) 方法，创建 Optional 对象，注意 t 允许为空：
        stringBuilderOptional = null;
        Optional<Optional<StringBuilder>> stringBuilderOptional1 = Optional.ofNullable(stringBuilderOptional);
        System.out.println(stringBuilderOptional1);
    }
}
