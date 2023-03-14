package top.flobby.spring.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Map;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description :
 * @create : 2023-03-14 13:58
 **/

@Data
@Component
@ConfigurationProperties(prefix = "person")
@Validated
public class Person {
    private Integer id;
    private String name;
    private List<String> hobby;
    private String[] family;
    private Map<String, Object> map;
    private Pet pet;
}
