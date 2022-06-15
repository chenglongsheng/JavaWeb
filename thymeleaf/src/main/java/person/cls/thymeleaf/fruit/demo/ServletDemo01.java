package person.cls.thymeleaf.fruit.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description: 保存作用域 demo01 和 demo02（session），
 * 会话级别，在同一次会话中可以获取
 * @author: CLS
 * @date: 2022-06-15-20:33
 * @version: 1.0
 */
@WebServlet("/demo01")
public class ServletDemo01 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("username", "tom");
        System.out.println(request.getSession().getAttribute("username"));
        response.sendRedirect("demo02");
//        request.getRequestDispatcher("demo02").forward(request, response);
    }
}
