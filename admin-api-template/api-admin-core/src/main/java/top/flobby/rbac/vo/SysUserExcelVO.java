package top.flobby.rbac.vo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import top.flobby.common.excel.DateConverter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @author : Flobby
 * @program : admin-api-template
 * @description : 用户信息 (导出) VO
 * @create : 2023-04-28 12:31
 **/

@Data
public class SysUserExcelVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1910289205039680581L;

    @ExcelIgnore
    private Long id;

    @ExcelProperty("用户名")
    private String username;

    @ExcelProperty("真实姓名")
    private String realName;

    @ExcelProperty("性别")
    private Integer gender;

    @ExcelProperty("邮箱")
    private String email;

    @ExcelProperty("手机号")
    private String mobile;

    @ExcelProperty("状态")
    private Integer status;

    @ExcelProperty(value = "创建时间", converter = DateConverter.class)
    private Date createTime;
}
