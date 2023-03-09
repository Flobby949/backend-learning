package top.flobby.advanced.collection.practice;

import top.flobby.advanced.entity.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Flobby
 * @program : java-advanced
 * @description :
 * @create : 2023-03-09 21:05
 **/

public class EmployeePractice {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "张三", 5000.0));
        employeeList.add(new Employee(2, "李四", 5500.0));
        employeeList.add(new Employee(3, "王五", 6600.0));
        System.out.println("员工姓名\t员工薪资");
        employeeList.forEach(System.out::println);
    }
}
