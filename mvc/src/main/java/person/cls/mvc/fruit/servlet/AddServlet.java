package person.cls.mvc.fruit.servlet;

import person.cls.mvc.fruit.dao.impl.FruitDAOImpl;
import person.cls.mvc.fruit.pojo.Fruit;
import person.cls.mvc.myssm.myspringmvc.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description: 添加水果请求
 * @author: CLS
 * @date: 2022-06-25-9:26
 * @version: 1.0
 */
@WebServlet("/add.do")
public class AddServlet extends ViewBaseServlet {

    private final FruitDAOImpl fruitDAO = new FruitDAOImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String fname = req.getParameter("fname");
        Integer price = Integer.parseInt(req.getParameter("price"));
        Integer fcount = Integer.parseInt(req.getParameter("fcount"));
        String remark = req.getParameter("remark");

        Fruit fruit = new Fruit(0, fname, price, fcount, remark);
        System.out.println(fruit);
        fruitDAO.addFruit(fruit);

        resp.sendRedirect("index");

    }
}
