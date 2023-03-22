package top.flobby.advanced.generics;

/**
 * @author : Flobby
 * @program : java-advanced
 * @description : 自定义泛型类
 * @create : 2023-03-22 13:58
 **/

public class NumberGeneric<T> {
    /**
     * 定义在类上的泛型，在类内部可以使用
     */
    private T number;

    public T getNumber() {
        return number;
    }

    public void setNumber(T number) {
        this.number = number;
    }

    public static void main(String[] args) {
        // 实例化对象，指定元素为整型
        NumberGeneric<Integer> integerNumberGeneric = new NumberGeneric<>();
        // 分别调用set，get方法
        integerNumberGeneric.setNumber(123);
        System.out.println("integerNumber = " + integerNumberGeneric.getNumber());

        // 实例化对象，指定元素为长整型
        NumberGeneric<Long> longNumberGeneric = new NumberGeneric<>();
        // 调用get，set
        longNumberGeneric.setNumber(20L);
        System.out.println("longNumber = " + longNumberGeneric.getNumber());

        // 实例化，double类型
        NumberGeneric<Double> doubleNumberGeneric = new NumberGeneric<>();
        // get,set
        doubleNumberGeneric.setNumber(200.0);
        System.out.println("doubleNumber = " + doubleNumberGeneric.getNumber());
    }
}
