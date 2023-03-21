package top.flobby.spring.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import top.flobby.spring.domain.StudentCourse;

import java.util.List;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description :
 * @create : 2023-03-21 16:54
 **/

public interface StudentCourseMapper {

    /**
     * 插入记录
     *
     * @param studentId 学生证
     * @param courseId  进程id
     * @return int
     */
    @Insert("INSERT INTO t_student_course(student_id, course_id) VALUES (#{studentId}, #{courseId}) ")
    int insertRecord(Integer studentId, Integer courseId);


    /**
     * 删除记录
     *
     * @param id id
     * @return int
     */
    @Delete("DELETE FROM t_student_course WHERE id = #{id} ")
    int deleteRecord(Integer id);

    /**
     * 更新记录
     *
     * @param studentCourse 学生课程
     * @return int
     */
    @Update("UPDATE t_student_course SET course_id = #{courseId}, student_id = #{studentId} WHERE id = #{id} ")
    int updateRecord(StudentCourse studentCourse);

    /**
     * 选择所有
     *
     * @return {@link List}<{@link StudentCourse}>
     */
    @Select("SELECT * FROM t_student_course ")
    List<StudentCourse> selectAll();
}
