package top.flobby.spring.mapper;

import top.flobby.spring.domain.Clazz;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description :
 * @create : 2023-03-21 14:29
 **/

public interface ClazzMapper {
    /**
     * 一对多查询 班级以及班级学生
     *
     * @param clazzId clazz id
     * @return {@link Clazz}
     */
    Clazz selectByOneToMany(Integer clazzId);
}
