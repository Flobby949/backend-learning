package top.flobby.spring.domain;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description :
 * @create : 2023-03-21 13:57
 **/

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_clazz")
public class Clazz {
    private Integer clazzId;
    private String clazzName;
    private Integer teacherId;
    /**
     * 在 clazz 中声明多方的集合
     */
    private List<StudentEntity> studentEntityList;
}
