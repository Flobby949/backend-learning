package top.flobby.advanced.generics;

/**
 * @author : Flobby
 * @program : java-advanced
 * @description : 定义两个泛型在类上
 * @create : 2023-03-22 14:06
 **/

public class KeyValueGeneric<K, V> {
    /**
     * 类型为K的key属性
     */
    private K key;

    /**
     * 类型为V的value属性
     */
    private V value;

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public static void main(String[] args) {
        // 实例化对象，指定元素类型为整型、长整型
        KeyValueGeneric<Integer, Long> integerLongKeyValueGeneric = new KeyValueGeneric<>();
        // 调用set、get方法
        integerLongKeyValueGeneric.setKey(200);
        integerLongKeyValueGeneric.setValue(300L);
        System.out.println("key = " + integerLongKeyValueGeneric.getKey());
        System.out.println("value = " + integerLongKeyValueGeneric.getValue());

        // 实例化对象，指定元素类型为浮点型、字符串类型
        KeyValueGeneric<Float, String> floatStringKeyValueGeneric = new KeyValueGeneric<>();
        // set、get方法
        floatStringKeyValueGeneric.setKey(0.5f);
        floatStringKeyValueGeneric.setValue("零点五");
        System.out.println("key = " + floatStringKeyValueGeneric.getKey());
        System.out.println("value = " + floatStringKeyValueGeneric.getValue());
    }
}
