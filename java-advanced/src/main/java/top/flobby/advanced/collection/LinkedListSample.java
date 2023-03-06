package top.flobby.advanced.collection;

import java.util.LinkedList;

/**
 * @author : Flobby
 * @program : java-advanced
 * @description : 链表
 * @create : 2023-03-06 23:31
 **/

public class LinkedListSample {
    public static void main(String[] args) {
        LinkedList<String> bookList = new LinkedList<>();
        bookList.add("三国演义");
        bookList.add(0, "水浒传");
        bookList.add("西游记");
        bookList.add("红楼梦");

        System.out.println("add 元素：" + bookList);

        bookList.addFirst("蒸汽革命");
        System.out.println("addFirst 元素：" + bookList);
        bookList.addLast("黄金时代");
        System.out.println("addLast 元素：" + bookList);
    }
}
