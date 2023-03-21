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
 * @create : 2023-03-21 13:58
 **/

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_teacher")
public class Teacher {
    private Integer teacherId;
    private String teacherName;
    private Integer clazzId;
    /**
     * 教室管理的班级对象：一对一
     */
    private Clazz clazz;
}
