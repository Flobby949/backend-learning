package top.flobby.spring.domain;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description :
 * @create : 2023-03-28 14:31
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    @NotNull(message = "主键不能为空")
    @Min(1)
    private Integer id;
    @NotBlank(message = "书名不能为空")
    private String title;
    @Size(min = 2, max = 5, message = "作者名在 2-5 字符之间")
    private String author;
}
