package top.flobby.spring.mapper;

import org.apache.ibatis.annotations.Param;
import top.flobby.spring.domain.StudentEntity;

import java.util.List;

/**
 * @author : JinChenXing
 * @program : spring-boot-learning
 * @description :
 * @create : 2023-03-21 14:39
 **/

public interface StudentMapper {
    /**
     * 多对一查询
     *
     * @param studentId 学生
     * @return {@link StudentEntity}
     */
    StudentEntity selectManyToOne(Integer studentId);

    /**
     * 插入一批学生
     *
     * @param studentEntityList 学生实体列表
     * @return int
     */
    int insertBatchStudent(@Param("studentList") List<StudentEntity> studentEntityList);

    /**
     * 批量删除
     *
     * @param ids id
     * @return int
     */
    int batchDelete(@Param("ids") List<Integer> ids);

    /**
     * 批量更新
     *
     * @param studentEntityList 学生实体列表
     * @return int
     */
    int batchUpdate(@Param("studentList") List<StudentEntity> studentEntityList);

    /**
     * 动态选择
     *
     * @param studentEntity 学生实体
     * @return {@link List}<{@link StudentEntity}>
     */
    List<StudentEntity> dynamicSelect(StudentEntity studentEntity);

    /**
     * 通过id获取学生信息
     *
     * @param studentId 学生证
     * @return {@link StudentEntity}
     */
    StudentEntity getStudentInfoById(Integer studentId);
}
