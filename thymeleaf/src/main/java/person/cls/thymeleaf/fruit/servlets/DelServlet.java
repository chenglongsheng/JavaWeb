package person.cls.thymeleaf.fruit.servlets;

import person.cls.thymeleaf.fruit.dao.impl.FruitDAOImpl;
import person.cls.thymeleaf.fruit.servlets.base.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description: 删除
 * @author: CLS
 * @date: 2022-06-16-15:56
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
