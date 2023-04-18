package top.flobby.mail.service;

import freemarker.template.Template;
import jakarta.annotation.Resource;
import jakarta.mail.MessagingException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;
import top.flobby.mail.entity.Article;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class MailServiceTest {

    @Resource
    private MailService mailService;
    @Resource
    private FreeMarkerConfig freeMarkerConfig;

    @Test
    void sendSimpleMail() {
        mailService.sendSimpleMail("2283582431@qq.com", "测试邮件", "jjjjjcx");
    }

    @Test
    void sendMimeMail() throws MessagingException {
        String content = """
                <h1>
                    HTML 邮件
                </h1>
                """;
        mailService.sendMimeMail("2541226493@qq.com", "mime测试", content);
    }

    @Test
    void sendTemplateMail() throws Exception {
        List<Article> articles = List.of(
                new Article(1, "文章111", new Date()),
                new Article(2, "文章222", new Date()),
                new Article(3, "文章333", new Date())
        );
        System.out.println(articles);
        Template template = freeMarkerConfig.getConfiguration().getTemplate("mail-template.ftl");
        Map<String, Object> map = new HashMap<>();
        map.put("articles", articles);
        String content = FreeMarkerTemplateUtils.processTemplateIntoString(template, map);
        mailService.sendMimeMail("2541226493@qq.com", "基于 Freemarker 模板的邮件", content);
    }
}