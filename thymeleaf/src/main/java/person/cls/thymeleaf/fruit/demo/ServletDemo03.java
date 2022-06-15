package person.cls.thymeleaf.fruit.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description: 保存作用域 demo03 和 demo04（request）,
 * 在一次请求中的作用域，内部转发为一次请求，重定向为两次请求
 * @author: CLS
 * @date: 2022-06-15-20:40
 * @version: 1.0
 */
@WebServlet("/demo03")
public class ServletDemo03 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("username", "tom");
        // 重定向demo04
//        resp.sendRedirect("demo04");
        req.getRequestDispatcher("demo04").forward(req, resp);

    }
}
