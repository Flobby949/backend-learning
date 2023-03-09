package top.flobby.advanced.collection;

import top.flobby.advanced.entity.Goods;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author : Flobby
 * @program : java-advanced
 * @description : 自定义排序
 * @create : 2023-03-09 20:57
 **/

public class CustomObjectSortSample {

    private static class CustomComparator implements Comparator<Goods> {

        @Override
        public int compare(Goods o1, Goods o2) {
            return o2.getTitle().compareTo(o1.getTitle());
        }
    }

    public List<Goods> sort(List<Goods> list) {
        CustomComparator customComparator = new CustomComparator();
        list.sort(customComparator);
        return list;
    }

    public static void main(String[] args) {
        List<Goods> goods = new ArrayList<>();
        goods.add(new Goods("18641351", "商品A"));
        goods.add(new Goods("12143518", "商品B"));
        goods.add(new Goods("36872148", "商品C"));
        goods.add(new Goods("91658745", "商品D"));
        System.out.println("排序前");
        System.out.println(goods);
        System.out.println("排序后");
        List<Goods> sortList = new CustomObjectSortSample().sort(goods);
        System.out.println(sortList);
    }
}
