package top.flobby.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.flobby.common.query.Query;

/**
 * @author : Flobby
 * @program : admin-api-template
 * @description : 通知公告查询
 * @create : 2023-04-20 22:35
 **/

@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "通知管理查询")
public class NoticeQuery extends Query {
    @Schema(description = "通知标题")
    private String title;
    @Schema(description = "通知内容")
    private String content;
}
