package top.flobby.spring.util;

import lombok.Data;
import top.flobby.spring.constant.ResponseConst;
import top.flobby.spring.exceptions.CustomException;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description :
 * @create : 2023-03-28 14:22
 **/

@Data
public class AjaxResponse {
    private Integer code;
    private String msg;
    private Object data;

    public static AjaxResponse error(Integer code, String msg) {
        AjaxResponse response = new AjaxResponse();
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }

    public static AjaxResponse error(Integer code) {
        AjaxResponse response = new AjaxResponse();
        response.setCode(code);
        response.setMsg(ResponseConst.ERROR_MSG);
        return response;
    }

    public static AjaxResponse error(CustomException e) {
        AjaxResponse response = new AjaxResponse();
        response.setCode(e.getCode());
        response.setMsg(e.getMsg());
        return response;
    }

    public static AjaxResponse success() {
        AjaxResponse response = new AjaxResponse();
        response.setCode(ResponseConst.SUCCESS_CODE);
        response.setMsg(ResponseConst.SUCCESS_MSG);
        return response;
    }

    public static AjaxResponse success(Object data) {
        AjaxResponse response = new AjaxResponse();
        response.setCode(ResponseConst.SUCCESS_CODE);
        response.setMsg(ResponseConst.SUCCESS_MSG);
        response.setData(data);
        return response;
    }
}
