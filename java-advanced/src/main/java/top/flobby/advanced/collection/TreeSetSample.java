package top.flobby.advanced.collection;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author : Flobby
 * @program : java-advanced
 * @description : TreeSet
 * @create : 2023-03-06 23:54
 **/

public class TreeSetSample {

    static class IntegerComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            // 降序
            return o2 - o1;
        }
    }


    private void sort() {
        Set<Integer> set = new TreeSet<>(new IntegerComparator());
        set.add(100);
        set.add(99);
        set.add(200);
        set.add(160);
        set.add(120);
        System.out.println(set);
    }

    public static void main(String[] args) {
        new TreeSetSample().sort();
    }

}
