package top.flobby.advanced.collection;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author : Flobby
 * @program : java-advanced
 * @description : HashMap
 * @create : 2023-03-07 09:32
 **/

public class HashMapSample {
    public static void main(String[] args) {
        // 实例化HashMap，HashMap在java.util包下
        HashMap<String, Object> student = new HashMap<>();
        // put方法插入键值对
        student.put("name", "张三");

        // 对同一个Key赋值，会覆盖原来的value，同时返回旧的value
        String oldName = (String) student.put("name", "李四");
        System.out.println(oldName);

        // Map可以存储多个键值对
        student.put("age", 18);
        student.put("height", 182);
        student.put("weight", 81);
        System.out.println(student);
    }
}
