package top.flobby.advanced.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Flobby
 * @program : java-advanced
 * @description : 无限定通配符 - ?
 * @create : 2023-03-22 14:22
 **/

public class AnyTypeGenericDemo {

    /**
     * 打印列表元素
     *
     * @param list 列表
     */
    public void printListElement(List<?> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }

    public static void main(String[] args) {
        // 实例化整型列表
        List<Integer> integerList = new ArrayList<>();
        // 添加元素
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        AnyTypeGenericDemo genericDemo = new AnyTypeGenericDemo();
        // 调用方法，打印元素
        genericDemo.printListElement(integerList);

        // 实例化一个字符串类型列表
        List<String> stringList = new ArrayList<>();
        // 添加元素
        stringList.add("Hello");
        stringList.add("Flobby");
        genericDemo.printListElement(stringList);
    }
}
