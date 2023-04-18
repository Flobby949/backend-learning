package top.flobby.mail.entity;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description :
 * @create : 2023-04-18 14:20
 **/

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    private Integer id;
    private String title;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
}
