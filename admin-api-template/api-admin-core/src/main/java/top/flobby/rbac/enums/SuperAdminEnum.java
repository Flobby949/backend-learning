package top.flobby.rbac.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

/**
 * @author : Flobby
 * @program : admin-api-template
 * @description : 超管枚举
 * @create : 2023-04-23 17:49
 **/

@Getter
@AllArgsConstructor
public enum SuperAdminEnum {
    /**
     * 是
     */
    YES(1, "是"),
    /**
     * 否
     */
    NO(0, "否");

    private final Integer value;
    private final String name;

    public static String getNameByValue(int value) {
        for (SuperAdminEnum s : SuperAdminEnum.values()) {
            if (s.getValue() == value) {
                return s.getName();
            }
        }
        return "";
    }

    public static Integer getValueByName(String name) {
        for (SuperAdminEnum s : SuperAdminEnum.values()) {
            if (Objects.equals(s.getName(), name)) {
                return s.getValue();
            }
        }
        return null;
    }
}