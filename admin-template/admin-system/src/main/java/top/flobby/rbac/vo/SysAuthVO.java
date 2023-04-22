package top.flobby.rbac.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * @author : Flobby
 * @program : admin-template
 * @description : 用户信息返回VO
 * @create : 2023-04-22 15:45
 **/

@Data
@Schema(description = "认证返回")
public class SysAuthVO implements Serializable {
    @Serial
    private static final long SerialVersionID = 1L;

    private SysUserVO user;
    private List<SysMenuVO> nav;
    private Set<String> authority;
}
