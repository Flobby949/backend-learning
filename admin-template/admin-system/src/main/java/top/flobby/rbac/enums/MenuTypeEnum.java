package top.flobby.rbac.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 菜单类型枚举
 *
 * @author flobby
 */
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
