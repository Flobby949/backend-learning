package top.flobby.spring.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import top.flobby.spring.domain.Discuss;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.startsWith;

@SpringBootTest
class DiscussRepositoryTest {
    @Autowired
    private DiscussRepository discussRepository;

    @Test
    void findByAuthorNotNull() {
        List<Discuss> authorNotNull = discussRepository.findByAuthorNotNull();
        authorNotNull.forEach(System.out::println);
    }

    @Test
    void findByContentLike() {
        String content = "详细";
        List<Discuss> contentLike = discussRepository.findByContentLike("%" + content + "%");
        contentLike.forEach(System.out::println);
    }

    @Test
    void findByAId() {
        List<Discuss> byAId = discussRepository.findByAIdEquals(1);
        byAId.forEach(System.out::println);
    }

    @Test
    void findById() {
        Optional<Discuss> byId = discussRepository.findById(1);
        byId.ifPresent(System.out::println);
        // 等同于
        // if (byId.isPresent()) {
        //     System.out.println(byId.get());
        // }
    }

    @Test
    void selectByPage() {
        Pageable pageable = PageRequest.of(1, 3);
        List<Discuss> discussList = discussRepository.selectByPage(1, pageable);
        discussList.forEach(System.out::println);
    }

    @Test
    void selectCommentByExample() {
        Discuss discuss = new Discuss();
        discuss.setAuthor("张三");
        Example<Discuss> example = Example.of(discuss);
        List<Discuss> list = discussRepository.findAll(example);
        list.forEach(System.out::println);
    }

    @Test
    void selectCommentByExampleMatcher() {
        Discuss discuss = new Discuss();
        discuss.setAuthor("张");
        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("author", startsWith());
        Example<Discuss> example = Example.of(discuss, matcher);
        discussRepository.findAll(example).forEach(System.out::println);
    }
}
