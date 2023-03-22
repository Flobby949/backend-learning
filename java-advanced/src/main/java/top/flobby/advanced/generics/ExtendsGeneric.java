package top.flobby.advanced.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Flobby
 * @program : java-advanced
 * @description : 上限通配符 -- extends
 * @create : 2023-03-22 14:26
 **/

public class ExtendsGeneric {
    /**
     * 遍历并打印集合中的每一个元素
     * extends通配符用来限定泛型的上限。
     * 例如：我们希望方法接收的 List 集合限定在数值类型内（float、integer、double、byte 等）
     * 不希望其他类型可以传入（比如字符串）
     *
     * @param list 要接收的集合
     */
    public void printListElement(List<? extends Number> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }

    public static void main(String[] args) {
        // 实例化一个整型的列表
        List<Integer> integers = new ArrayList<>();
        // 添加元素
        integers.add(1);
        integers.add(2);
        integers.add(3);
        ExtendsGeneric generic = new ExtendsGeneric();
        // 调用printListElement()方法
        generic.printListElement(integers);
    }

}
