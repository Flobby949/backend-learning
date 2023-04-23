package top.flobby.rbac.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 首页 欢迎信息
 *
 * @author flobby
 */
@RestController
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "项目已启动！";
    }
}
