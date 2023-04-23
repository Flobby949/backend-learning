package top.flobby.rbac.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author : Flobby
 * @program : admin-api-template
 * @description : 菜单枚举
 * @create : 2023-04-23 17:49
 **/

@Getter
@AllArgsConstructor
public enum MenuTypeEnum {
    /**
     * 菜单
     */
    MENU(0),
    /**
     * 按钮
     */
    BUTTON(1),
    /**
     * 接口
     */
    INTERFACE(2);

    private final int value;

}
