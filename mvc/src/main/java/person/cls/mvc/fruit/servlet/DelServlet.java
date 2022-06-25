package person.cls.mvc.fruit.servlet;

import person.cls.mvc.fruit.dao.impl.FruitDAOImpl;
import person.cls.mvc.myssm.myspringmvc.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description: 删除水果请求
 * @author: CLS
 * @date: 2022-06-25-9:26
 * @version: 1.0
 */
@WebServlet("/del.do")
public class DelServlet extends ViewBaseServlet {

    private final FruitDAOImpl fruitDAO = new FruitDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int fid = Integer.parseInt(req.getParameter("fid"));
//        System.out.println(fid);
        fruitDAO.delFruitById(fid);
        resp.sendRedirect("index");
    }
}
