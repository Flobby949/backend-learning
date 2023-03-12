package top.flobby.ioc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Flobby
 * @program : ioc-demo
 * @description :
 * @create : 2023-03-12 11:32
 **/

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Apple {
    private String name;
    private String origin;
}
