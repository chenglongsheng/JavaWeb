package person.cls.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet生命周期
 */
public class LifeCycleServlet extends HttpServlet {

    @Override
    public void init() {
        System.out.println("初始化中...");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("服务中...");
    }

    @Override
    public void destroy() {
        System.out.println("销毁中...");
    }
}
