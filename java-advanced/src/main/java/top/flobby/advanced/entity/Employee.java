package top.flobby.advanced.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Flobby
 * @program : java-advanced
 * @description :
 * @create : 2023-03-09 21:03
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Integer id;
    private String name;
    private Double salary;

    @Override
    public String toString() {
        return name + " \t" + salary;
    }
}
