package top.flobby.spring.service;

import org.springframework.stereotype.Service;
import top.flobby.spring.domain.Article;
import top.flobby.spring.enums.ExceptionEnum;
import top.flobby.spring.exceptions.CustomException;

import java.util.List;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description :
 * @create : 2023-03-28 14:32
 **/

@Service
public class ExceptionService {
    public void getSysException() {
        throw new CustomException(ExceptionEnum.SYSTEM_EXCEPTION);
    }

    public void getClientException() {
        throw new CustomException(ExceptionEnum.CLIENT_EXCEPTION);
    }

    public Article getArticle(Integer id) {
        List<Article> articleList = List.of(new Article(1, "Spring", "Author A"),
                new Article(2, "Vue", "Author B"),
                new Article(3, "Flutter", "Author C"));
        return articleList.stream().filter(article -> article.getId().equals(id)).toList().get(0);
    }
}
