package top.flobby.spring.mapper;

import top.flobby.spring.domain.Teacher;

/**
 * @author : JinChenXing
 * @program : spring-boot-learning
 * @description :
 * @create : 2023-03-21 14:01
 **/

public interface TeacherMapper {

    /**
     * 一对一查询老师 & 班级
     *
     * @param teacherId 老师id
     * @return {@link Teacher}
     */
    Teacher selectOneByOne(Integer teacherId);
}
