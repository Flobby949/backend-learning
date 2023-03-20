package top.flobby.spring.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.flobby.spring.domain.Discuss;
import top.flobby.spring.repository.DiscussRepository;

import java.util.List;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description :
 * @create : 2023-03-20 15:11
 **/

@Controller
@AllArgsConstructor
public class DiscussController {
    private final DiscussRepository discussRepository;

    // @GetMapping("discuss")
    public String getList(ModelMap map) {
        Pageable pageable = PageRequest.of(0, 2);
        List<Discuss> discussList = discussRepository.selectByPage(1, pageable);
        map.put("discussList", discussList);
        map.put("title", "你好 world");
        return "index";
    }
}
