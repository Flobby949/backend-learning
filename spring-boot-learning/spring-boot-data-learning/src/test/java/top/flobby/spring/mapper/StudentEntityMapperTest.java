package top.flobby.spring.mapper;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.flobby.spring.domain.StudentEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

@SpringBootTest
@Slf4j
class StudentEntityMapperTest {
    @Resource
    private StudentMapper studentMapper;

    @Test
    void selectManyToOne() {
        System.out.println(studentMapper.selectManyToOne(1001));
    }

    @Test
    void insertBatchStudent() {
        List<StudentEntity> studentEntityList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            StudentEntity student = StudentEntity.builder()
                    .studentId(2000 + i)
                    .clazzId(i % 2 == 0 ? 1 : 2)
                    .studentName("学生" + i)
                    .hometown("家乡")
                    .birthday(LocalDate.now())
                    .build();
            studentEntityList.add(student);
        }
        System.out.println(studentMapper.insertBatchStudent(studentEntityList));
    }

    @Test
    void batchUpdate() {
        List<StudentEntity> studentEntityList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            StudentEntity student = StudentEntity.builder()
                    .studentId(2010 + i)
                    .clazzId(i % 2 == 0 ? 1 : 2)
                    .studentName("新学生" + i)
                    .hometown("新家乡")
                    .birthday(LocalDate.now())
                    .build();
            studentEntityList.add(student);
        }
        System.out.println(studentMapper.batchUpdate(studentEntityList));
    }

    @Test
    void batchDelete() {
        System.out.println(studentMapper.batchDelete(List.of(2001, 2003, 2005, 2007)));
    }

    @Test
    void dynamicSelect() {
        StudentEntity student = StudentEntity.builder()
                .clazzId(1)
                .hometown("新")
                .build();
        System.out.println(studentMapper.dynamicSelect(student));
    }

    @Test
    void getStudentInfoById() {
        StudentEntity student = studentMapper.getStudentInfoById(1001);
        StringJoiner stringJoiner = new StringJoiner(",");
        student.getCourseList().forEach(item -> {
            stringJoiner.add(item.getCourse().getCourseName());
        });
        log.info("{}的学生{}，学号{}，家乡{}，生日{}。选择{}课程",
                student.getClazz().getClazzName(),
                student.getStudentName(),
                student.getStudentId(),
                student.getHometown(),
                student.getBirthday(),
                stringJoiner
        );
    }
}