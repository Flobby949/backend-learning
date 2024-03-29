package top.flobby.security.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import top.flobby.common.exception.ErrorCode;
import top.flobby.common.utils.HttpContextUtils;
import top.flobby.common.utils.JsonUtils;
import top.flobby.common.utils.Result;

import java.io.IOException;

 /**
 * SpringSecurity针对匿名访问，提供了AuthenticationEntryPoint接口，
 * 用来解决匿名访问无权限时的异常信息。我们可以通过实现该接口，用来处理没有访问权限的响应数据
 * 然后再把 SecurityAuthenticationEntryPoint 添加在 SecurityConfig ，就会生效
 *
 * @author : Flobby
 * @program : admin-api-template
 * @description : 匿名用户(token不存在、错误)，异常处理器
 * @create : 2023-04-23 17:16
 **/
public class SecurityAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        response.setContentType("application/json; charset=utf-8");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Origin", HttpContextUtils.getOrigin());

        response.getWriter().print(JsonUtils.toJsonString(Result.error(ErrorCode.UNAUTHORIZED)));
    }
}