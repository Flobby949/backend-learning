package top.flobby.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * @author : Flobby
 * @program : admin-api-template
 * @description : 柱状图VO
 * @create : 2023-04-25 13:47
 **/

@Data
@Builder
@Schema(description = "柱状图")
public class BarVO implements Serializable {
    @Serial
    private static final long serialVersionUID = -6085434761016425771L;

    @Schema(description = "x轴数据", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<String> x;

    @Schema(description = "y轴数据", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<Integer> y;
}
