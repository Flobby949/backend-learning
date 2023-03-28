package top.flobby.advanced.method_ref;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author : Flobby
 * @program : java-advanced
 * @description : 类引用构造方法
 * @create : 2023-03-29 00:26
 **/

public class MethodReferencesDemo2 {
    static class Person {
        private String name;

        public Person() {
            System.out.println("无参数构造方法执行了");
        }

        public Person(String name) {
            System.out.println("单参数构造方法执行了");
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

    public static void main(String[] args) {

        // 使用 Lambda 表达式，调用无参构造方法
        Supplier<Person> supplier1 = () -> new Person();
        supplier1.get();

        // 使用方法引用，引用无参构造方法
        Supplier<Person> supplier2 = Person::new;
        supplier2.get();

        // 使用 Lambda 表达式，调用单参构造方法
        Function<String, Person> function1 = name -> new Person(name);
        Person person1 = function1.apply("小慕");
        System.out.println(person1.getName());


        // 使用方法引用，引用单参构造方法
        Function<String, Person> function2 = Person::new;
        Person person2 = function2.apply("小明");
        System.out.println(person2.getName());
    }
}
