package top.flobby.spring.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description :
 * @create : 2023-03-27 14:53
 **/

@Slf4j
@WebServlet("/servlet/test")
public class CustomServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("进入 servlet");
    }
}
