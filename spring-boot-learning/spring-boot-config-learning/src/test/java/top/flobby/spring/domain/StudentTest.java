package top.flobby.spring.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.flobby.spring.prop.MyProperties;

@SpringBootTest
class StudentTest {
    @Autowired
    private Student student;
    @Autowired
    private MyProperties myProperties;

    @Test
    void test01() {
        System.out.println(myProperties);
    }
}