package top.flobby.document.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description :
 * @create : 2023-04-18 16:29
 **/

@RestController
@Tag(name = "HelloController", description = "测试接口")
public class HelloController {

    @GetMapping("test")
    @Operation(summary = "hello", description = "test 方法")
    public String test() {
        return "Hello Springdoc";
    }
}
