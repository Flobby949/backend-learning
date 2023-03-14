package top.flobby.spring.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PersonTest {
    @Autowired
    private Person person;

    @Test
    void test01() {
        System.out.println(person);
    }

}