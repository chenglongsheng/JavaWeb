package person.cls.thymeleaf.fruit.demo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description: 保存作用域 demo01 和 demo02（application），
 * 应用程序级别，tomcat生命周期内所有的值都可以获取，不区分请求和会话
 * @author: CLS
 * @date: 2022-06-15-20:43
 * @version: 1.0
 */
@WebServlet("/demo05")
public class ServletDemo05 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = req.getServletContext();
        servletContext.setAttribute("username", "tom");
        resp.sendRedirect("demo06");
    }
}
