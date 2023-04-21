package top.flobby.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.flobby.mybatis.entity.BaseEntity;

/**
 * @author : Flobby
 * @program : admin-template
 * @description : notice
 * @create : 2023-04-20 22:01
 **/


@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_notice")
public class NoticeEntity extends BaseEntity {
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;
}
