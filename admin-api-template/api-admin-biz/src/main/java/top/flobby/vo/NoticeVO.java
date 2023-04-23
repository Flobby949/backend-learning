package top.flobby.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import top.flobby.common.utils.DateUtils;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @author : Flobby
 * @program : admin-api-template
 * @description :
 * @create : 2023-04-20 22:27
 **/

@Data
@Schema(description = "通知")
public class NoticeVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Schema(description = "id")
    private Long id;

    @Schema(description = "通知标题", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "标题不能为空")
    private String title;

    @Schema(description = "内容", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "内容不能为空")
    private String content;

    @Schema(description = "创建时间")
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    private Date createTime;

}
