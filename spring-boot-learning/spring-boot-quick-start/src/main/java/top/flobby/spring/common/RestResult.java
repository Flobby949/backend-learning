package top.flobby.spring.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description :
 * @create : 2023-03-13 15:48
 **/

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestResult {
    private Integer code;
    private String msg;
    private Object data;

}
