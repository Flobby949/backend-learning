package top.flobby.advanced.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author : Flobby
 * @program : java-advanced
 * @description : 集合遍历
 * @create : 2023-03-06 23:34
 **/

public class ListLoopSample {
    public static void main(String[] args) {
        // 创建集合
        List<String> bookList = new ArrayList<>();
        bookList.add("三国演义");
        bookList.add("水浒传");
        bookList.add("西游记");
        bookList.add("红楼梦");

        System.out.println("====== 增强型for循环遍历 ======");
        // 方式1：增强型for循环
        for (String book : bookList) {
            System.out.println(book);
        }
        System.out.println();

        // 方式2：forEach + 方法引用
        System.out.println("====== forEach + 方法引用 ======");
        bookList.forEach(System.out::println);
        System.out.println();

        // 方式3：Iterator 迭代器
        System.out.println("====== Iterator 迭代器 ======");
        Iterator<String> iterator = bookList.iterator();
        while (iterator.hasNext()) {
            // 提取下一个元素，同时指针向后移动
            String next = iterator.next();
            System.out.println(next);
        }
    }
}
