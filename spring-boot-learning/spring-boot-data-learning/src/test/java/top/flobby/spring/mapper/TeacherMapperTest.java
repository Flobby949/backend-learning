package top.flobby.spring.mapper;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherMapperTest {
    @Resource
    private TeacherMapper teacherMapper;

    @Test
    void selectOneByOne() {
        System.out.println(teacherMapper.selectOneByOne(1));
    }
}