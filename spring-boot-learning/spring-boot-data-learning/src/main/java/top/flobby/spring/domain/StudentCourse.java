package top.flobby.spring.domain;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description : 学生选课表
 * @create : 2023-03-21 16:50
 **/

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_student_course")
public class StudentCourse {
    private Integer id;
    private Integer studentId;
    private Integer courseId;
    private Course course;
}
