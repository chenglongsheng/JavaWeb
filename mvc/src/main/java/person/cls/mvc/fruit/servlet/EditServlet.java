package person.cls.mvc.fruit.servlet;

import person.cls.mvc.fruit.dao.impl.FruitDAOImpl;
import person.cls.mvc.fruit.pojo.Fruit;
import person.cls.mvc.myssm.myspringmvc.ViewBaseServlet;
import person.cls.mvc.myssm.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description: 编辑水果请求
 * @author: CLS
 * @date: 2022-06-25-9:27
 * @version: 1.0
 */
@WebServlet("/edit.do")
public class EditServlet extends ViewBaseServlet {

    private final FruitDAOImpl fruitDAO = new FruitDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String fid = req.getParameter("fid");
        if (!StringUtils.isEmpty(fid)) {
            int id = Integer.parseInt(fid);
            Fruit fruitInfo = fruitDAO.getFruitInfo(id);
            req.setAttribute("fruit", fruitInfo);
            processTemplate("edit", req, resp);
        }

    }
}
