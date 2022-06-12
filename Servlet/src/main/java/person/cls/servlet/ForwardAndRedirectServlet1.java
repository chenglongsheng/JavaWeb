package person.cls.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ForwardAndRedirectServlet1 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("这是1...");
        // 服务器内部转发 1 收到请求，转给路由为forwardAndRedirect2的服务去处理请求并响应
//        req.getRequestDispatcher("forwardAndRedirect2").forward(req, resp);

        // 客户端重定向
        resp.sendRedirect("forwardAndRedirect2");

    }
}
