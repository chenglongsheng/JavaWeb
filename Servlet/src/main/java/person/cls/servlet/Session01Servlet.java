package person.cls.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * session保存作用域演示
 * <p>
 * session1
 */
public class Session01Servlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("name", "张三");
        Object name = req.getAttribute("name");
        System.out.println("name: " + name);
    }
}
