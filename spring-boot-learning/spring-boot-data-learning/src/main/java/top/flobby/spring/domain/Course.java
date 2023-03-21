package top.flobby.spring.domain;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description :
 * @create : 2023-03-21 14:06
 **/

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_course")
public class Course {
    private Integer courseId;
    private String courseName;
}
