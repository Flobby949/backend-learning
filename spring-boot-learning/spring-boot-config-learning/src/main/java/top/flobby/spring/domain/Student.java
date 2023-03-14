package top.flobby.spring.domain;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description :
 * @create : 2023-03-14 14:35
 **/

@Data
@Component
public class Student {
    @Value("${student.name}")
    private String name;
    private Integer id;
}
