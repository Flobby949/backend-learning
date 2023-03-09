package top.flobby.advanced.collection.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : Flobby
 * @program : java-advanced
 * @description :
 * @create : 2023-03-09 21:08
 **/

public class SortPractice {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("orange");
        fruits.add("tomato");
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("litchi");
        System.out.println("排序前");
        fruits.forEach(item -> System.out.print(item + " \t"));
        System.out.println();
        System.out.println("排序后");
        List<String> sortList = fruits.stream().sorted().toList();
        sortList.forEach(item -> System.out.print(item + " \t"));
    }
}
