package top.flobby.spring.domain;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description :
 * @create : 2023-03-21 14:00
 **/

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_student")
public class StudentEntity {
    private Integer studentId;
    private Integer clazzId;
    private String studentName;
    private String hometown;
    private LocalDate birthday;
    private Clazz clazz;
    private List<StudentCourse> courseList;
}
