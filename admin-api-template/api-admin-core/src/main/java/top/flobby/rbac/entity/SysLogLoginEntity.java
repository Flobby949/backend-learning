package top.flobby.rbac.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author : Flobby
 * @program : admin-api-template
 * @description : 登录日志
 * @create : 2023-04-23 17:52
 **/

@Data
@TableName("sys_log_login")
public class SysLogLoginEntity {

    /**
     * 自增主键
     */
    @TableId
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 登录ip
     */
    private String ip;

    /**
     * 登录地点
     */
    private String address;

    /**
     * 登录设备的UA
     */
    private String userAgent;

    /**
     * 登录状态  0：失败   1：成功
     */
    private Integer status;

    /**
     * 操作信息   0：登录成功   1：退出成功  2：验证码错误  3：账号密码错误
     */
    private Integer operation;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

}
