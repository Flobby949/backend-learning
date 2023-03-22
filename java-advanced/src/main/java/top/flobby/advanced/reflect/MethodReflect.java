package top.flobby.advanced.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author : Flobby
 * @program : java-advanced
 * @description : 反射调用方法
 * @create : 2023-03-22 15:08
 **/

public class MethodReflect {
        public static void main(String[] args) throws Exception {
            // 实例化字符串对象
            String name = "Colorful";
            // 获取 method 对象
            Method method = String.class.getMethod("replace", CharSequence.class, CharSequence.class);
            // 调用 invoke() 执行方法
            String result = (String) method.invoke(name, "ful", "");
            System.out.println(result);
        }
}
