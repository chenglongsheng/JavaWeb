package person.cls.thymeleaf.fruit.servlets;

import person.cls.thymeleaf.fruit.dao.impl.FruitDAOImpl;
import person.cls.thymeleaf.fruit.pojo.Fruit;
import person.cls.thymeleaf.fruit.servlets.base.ViewBaseServlet;
import person.cls.thymeleaf.fruit.util.StringUtils;

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

    private final FruitDAOImpl fruitDAO = new FruitDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int pageNo = 1;

        String pageNoStr = req.getParameter("pageNo");
        if (!StringUtils.isEmpty(pageNoStr)) {
            pageNo = Integer.parseInt(pageNoStr);
        }

        List<Fruit> fruitList = fruitDAO.getFruitList(pageNo);
        int size = fruitDAO.getFruitList().size();

        int pageCount = (size + 5 - 1) / 5;

        HttpSession session = req.getSession();
        session.setAttribute("fruitList", fruitList);
        session.setAttribute("pageNo", pageNo);
        session.setAttribute("pageCount", pageCount);

        processTemplate("index", req, resp);

    }
}
