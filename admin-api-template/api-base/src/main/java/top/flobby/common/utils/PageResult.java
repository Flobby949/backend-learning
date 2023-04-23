package top.flobby.common.utils;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * @author : Flobby
 * @program : admin-api-template
 * @description : 分页返回
 * @create : 2023-04-23 17:00
 **/
@Data
@Schema(description = "分页数据")
public class PageResult<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "总记录数")
    private int total;

    @Schema(description = "列表数据")
    private List<T> list;

    /**
     * 分页
     * @param list   列表数据
     * @param total  总记录数
     */
    public PageResult(List<T> list, long total) {
        this.list = list;
        this.total = (int)total;
    }
}