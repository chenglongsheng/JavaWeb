package person.cls.mvc.myssm.myspringmvc;

import person.cls.mvc.myssm.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description: Servlet调用中心（核心控制器）
 * @author: CLS
 * @date: 2022-06-25-11:02
 * @version: 1.0
 */
@WebServlet("*.do")
public class DispatchServlet extends ViewBaseServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置编码
        request.setCharacterEncoding("UTF-8");
        String servletPath = request.getServletPath();
        // 根据path调度给具体的servlet
        // 把 /*.do -> *
        String name = StringUtils.substringFromPath(servletPath);

    }
}
