package top.flobby.spring.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.flobby.spring.domain.Article;
import top.flobby.spring.repository.ArticleRepository;

import java.util.Optional;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description :
 * @create : 2023-03-20 16:16
 **/

@Controller
@AllArgsConstructor
public class ArticleController {
    private final ArticleRepository articleRepository;

    @GetMapping("index")
    public String indexPage(ModelMap map) {
        map.put("articleList", articleRepository.findAll());
        return "index";
    }

    @GetMapping("detail")
    public String articleDetail(@RequestParam(value = "id", required = false) Integer id, ModelMap map) {
        Optional<Article> articleOptional = articleRepository.findById(id);
        articleOptional.ifPresent(article -> map.put("article", article));
        return "detail";
    }
}
