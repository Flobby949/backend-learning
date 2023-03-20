package top.flobby.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.flobby.spring.domain.Article;

/**
 * @author : JinChenXing
 * @program : spring-boot-learning
 * @description :
 * @create : 2023-03-20 16:14
 **/

public interface ArticleRepository extends JpaRepository<Article, Integer> {

}
