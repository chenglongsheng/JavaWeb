package person.cls.thymeleaf.fruit.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description: 保存作用域 demo01 和 demo02（session）
 * @author: CLS
 * @date: 2022-06-15-20:34
 * @version: 1.0
 */
@WebServlet("/demo02")
public class ServletDemo02 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object username = req.getSession().getAttribute("username");
        System.out.println("username(session) = " + username);
    }
}
