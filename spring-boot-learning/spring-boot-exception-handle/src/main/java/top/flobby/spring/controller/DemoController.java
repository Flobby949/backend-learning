package top.flobby.spring.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import top.flobby.spring.auth.CheckAuthorization;
import top.flobby.spring.auth.CheckToken;
import top.flobby.spring.domain.Article;
import top.flobby.spring.service.ExceptionService;
import top.flobby.spring.util.AjaxResponse;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description : 测试接口
 * @create : 2023-03-28 14:37
 **/

@RestController
@AllArgsConstructor
public class DemoController {
    private final ExceptionService exceptionService;

    @GetMapping("demo/{id}")
    @CheckToken
    @CheckAuthorization("admin")
    public AjaxResponse getArticle(@PathVariable Integer id) {
        if (id > 3) {
            exceptionService.getSysException();
        } else if (id <= 0) {
            exceptionService.getClientException();
        } else {
            return AjaxResponse.success(exceptionService.getArticle(id));
        }
        return null;
    }

    @PostMapping("article")
    public AjaxResponse releaseArticle(@Valid @RequestBody Article article) {
        return AjaxResponse.success();
    }
}
