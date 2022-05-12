package person.cls.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 会话跟踪技术，绑定会话id确保同一客户端访问
 */
public class SessionServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        String id = session.getId();
        System.out.println("sessionId：" + id);
    }

}
