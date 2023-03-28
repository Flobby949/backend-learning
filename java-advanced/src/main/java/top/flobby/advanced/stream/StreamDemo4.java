package top.flobby.advanced.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author : Flobby
 * @program : java-advanced
 * @description :
 * @create : 2023-03-29 00:35
 **/

public class StreamDemo4 {
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

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Person person = (Person) o;
            return age == person.age &&
                    Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }
    }

    /**
     * 创建一个Person的集合
     * @return List
     */
    public static List<Person> createPeople() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("小明", 15));
        people.add(new Person("小芳", 20));
        people.add(new Person("小李", 18));
        people.add(new Person("小付", 23));
        people.add(new Person("小付", 23));
        people.add(new Person("大飞", 22));
        people.add(new Person("大飞", 22));
        people.add(new Person("大飞", 22));
        return people;
    }
}
