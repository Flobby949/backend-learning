package top.flobby.spring.enums;

import lombok.Getter;
import top.flobby.spring.constant.ResponseConst;

/**
 * @author : JinChenXing
 * @program : spring-boot-learning
 * @description : 异常枚举
 * @create : 2023-03-28 14:16
 **/

@Getter
public enum ExceptionEnum {
    /**
     * 系统异常
     */
    SYSTEM_EXCEPTION(ResponseConst.SERVER_ERROR_CODE, ResponseConst.SYSTEM_ERROR),
    /**
     * 客户端异常
     */
    CLIENT_EXCEPTION(ResponseConst.CLIENT_ERROR_CODE, ResponseConst.CLIENT_ERROR),
    /**
     * 其他异常
     */
    OTHER_EXCEPTION(ResponseConst.OTHER_ERROR_CODE, ResponseConst.OTHER_ERROR),
    ;

    ExceptionEnum(Integer code, String des) {
        this.code = code;
        this.des = des;
    }

    private final Integer code;
    private final String des;
}
