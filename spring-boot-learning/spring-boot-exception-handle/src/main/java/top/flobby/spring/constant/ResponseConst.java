package top.flobby.spring.constant;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description : 自定义常量
 * @create : 2023-03-28 14:15
 **/

public interface ResponseConst {
    /**
     * 状态码
     */
    /**
     * 成功代码
     */
    Integer SUCCESS_CODE = 200;
    /**
     * 客户端错误代码
     */
    Integer CLIENT_ERROR_CODE = 400;
    /**
     * 服务器错误代码
     */
    Integer SERVER_ERROR_CODE = 500;
    /**
     * 其他错误代码
     */
    Integer OTHER_ERROR_CODE = 999;
    /**
     * 描述信息
     */
    /**
     * 成功描述
     */
    String SUCCESS_MSG = "请求成功";
    /**
     * 错误描述
     */
    String ERROR_MSG = "请求失败";
    /**
     * 系统错误
     */
    String SYSTEM_ERROR = "系统异常";
    /**
     * 客户端错误
     */
    String CLIENT_ERROR = "客户端异常";
    /**
     * 其他错误
     */
    String OTHER_ERROR = "其他异常";
}
