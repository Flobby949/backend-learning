package top.flobby.spring.mapper;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.flobby.spring.domain.Course;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMapperTest {
    @Resource
    private CourseMapper courseMapper;

    @Test
    void insertOne() {
        int count = courseMapper.insertOne(Course.builder()
                .courseId(1)
                .courseName("Web应用开发")
                .build());
        assertEquals(1, count);
    }

    @Test
    void insertBatch() {
        List<Course> courseList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            courseList.add(Course.builder()
                    .courseId(i + 100)
                    .courseName("课程" + i)
                    .build());
        }
        int count = courseMapper.insertBatch(courseList);
        assertEquals(10, count);
    }

    @Test
    void deleteById() {
        int count = courseMapper.deleteById(1);
        assertEquals(1, count);
    }

    @Test
    void deleteBatch() {
        int count = courseMapper.deleteBatch(List.of(101, 102, 103, 104, 105, 106, 107, 108, 109, 110));
        assertEquals(10, count);
    }

    @Test
    void updateById() {
        int count = courseMapper.updateById(Course.builder()
                .courseId(101)
                .courseName("新课程")
                .build());
        assertEquals(1, count);
    }

    @Test
    void updateBatch() {

        List<Course> courseList = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            courseList.add(Course.builder()
                    .courseId(i + 102)
                    .courseName("新课程" + i)
                    .build());
        }
        int count = courseMapper.updateBatch(courseList);
        assertEquals(1, count);
    }

    @Test
    void selectDynamic() {
        System.out.println(courseMapper.selectDynamic(Course.builder()
                .courseName("新课")
                .build()));
    }
}