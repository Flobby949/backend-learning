package top.flobby.rbac.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author : Flobby
 * @program : admin-template
 * @description : 登录日志
 * @create : 2023-04-23 13:37
 **/

@Data
@EqualsAndHashCode(callSuper=false)
@TableName("sys_log_login")
public class SysLogLoginEntity {

    /**
     * 主键
     */
    @TableId
    private Long id;
    private String username;
    private String ip;
    private String address;
    private String userAgent;
    /**
     *  '登录状态  0：失败   1：成功'
     */
    private Integer status;
    /**
     *  '操作信息   0：登录成功   1：退出成功  2：验证码错误  3：账号密码错误'
     */
    private Integer operation;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
}
