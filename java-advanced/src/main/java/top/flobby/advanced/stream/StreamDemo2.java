package top.flobby.advanced.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author : Flobby
 * @program : java-advanced
 * @description :
 * @create : 2023-03-29 00:32
 **/

public class StreamDemo2 {
    static class Person {
        private String name;
        private int age;

        public Person() { }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    /**
     * 创建一个Person的集合
     * @return List
     */
    public static List<Person> createPeople() {
        List<Person> people = new ArrayList<>();
        Person person1 = new Person("小明", 15);
        Person person2 = new Person("小芳", 20);
        Person person3 = new Person("小李", 18);
        Person person4 = new Person("小付", 23);
        Person person5 = new Person("大飞", 22);
        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.add(person4);
        people.add(person5);
        return people;
    }

    public static void main(String[] args) {
        List<Person> people = createPeople();
        // 创建 Stream 对象
        Stream<Person> stream = people.stream();
        // 过滤年龄大于 20 的person
        Stream<Person> personStream = stream.filter(person -> person.getAge() >= 20);
        // 触发终止操作才能执行中间操作，遍历列表中元素并打印
        personStream.forEach(System.out::println);

        // 合并简写
        // stream.filter(person -> person.getAge() >= 20).forEach(System.out::println);
    }
}
