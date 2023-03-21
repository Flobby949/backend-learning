package top.flobby.spring.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.flobby.spring.domain.StudentEntity;
import top.flobby.spring.mapper.StudentMapper;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description :
 * @create : 2023-03-21 18:36
 **/

@RestController
public class StudentController {
    @Resource
    private StudentMapper studentMapper;

    /**
     * 得到学生信息
     *
     * @return {@link StudentEntity}
     */
    @GetMapping("{id}")
    public StudentEntity getStudentInfo(@PathVariable Integer id) {
        return studentMapper.getStudentInfoById(id);
    }
}
