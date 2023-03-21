package top.flobby.spring.mapper;

import org.apache.ibatis.annotations.Param;
import top.flobby.spring.domain.Course;

import java.util.List;

/**
 * @author : JinChenXing
 * @program : spring-boot-learning
 * @description :
 * @create : 2023-03-21 16:08
 **/

public interface CourseMapper {
    /**
     * 插入
     *
     * @param course 课程
     * @return int
     */
    int insertOne(Course course);

    /**
     * 插入
     *
     * @param courseList 课程
     * @return int
     */
    int insertBatch(@Param("courseList") List<Course> courseList);

    /**
     * 删除通过id
     *
     * @param courseId 进程id
     * @return int
     */
    int deleteById(int courseId);

    /**
     * 删除批处理
     *
     * @param ids id
     * @return int
     */
    int deleteBatch(@Param("ids") List<Integer> ids);

    /**
     * 更新通过id
     *
     * @param course 课程
     * @return int
     */
    int updateById(Course course);

    /**
     * 批处理更新
     *
     * @param courseList 课程列表
     * @return int
     */
    int updateBatch(@Param("courses") List<Course> courseList);

    /**
     * 动态查询
     *
     * @param course 课程
     * @return {@link List}<{@link Course}>
     */
    List<Course> selectDynamic(Course course);

}
