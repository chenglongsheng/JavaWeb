package person.cls.thymeleaf.fruit.servlets;

import person.cls.thymeleaf.fruit.dao.impl.FruitDAOImpl;
import person.cls.thymeleaf.fruit.pojo.Fruit;
import person.cls.thymeleaf.fruit.servlets.base.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @description: IndexServlet
 * @author: CLS
 * @date: 2022-06-14-9:41
 * @version: 1.0
 */
@WebServlet("/index")
public class IndexServlet extends ViewBaseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        FruitDAOImpl fruitDAO = new FruitDAOImpl();
        List<Fruit> fruitList = fruitDAO.getFruitList();

        HttpSession session = req.getSession();
        session.setAttribute("fruitList", fruitList);

        processTemplate("index", req, resp);

    }
}
