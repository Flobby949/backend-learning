package top.flobby.advanced.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author : Flobby
 * @program : java-advanced
 * @description : 反射调用构造方法
 * @create : 2023-03-22 14:51
 **/

public class ConstructorReflect {
    public static void main(String[] args) throws Exception {
        // 获取构造方法
        Constructor<StringBuffer> constructor = StringBuffer.class.getConstructor(String.class);
        // 调用构造方法
        Object str = constructor.newInstance("Hello World");
        System.out.println(str);
    }

}
