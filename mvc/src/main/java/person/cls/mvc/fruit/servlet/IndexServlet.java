package person.cls.mvc.fruit.servlet;

import person.cls.mvc.fruit.dao.impl.FruitDAOImpl;
import person.cls.mvc.fruit.pojo.Fruit;
import person.cls.mvc.myssm.myspringmvc.ViewBaseServlet;
import person.cls.mvc.myssm.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @description: 首页请求
 * @author: CLS
 * @date: 2022-06-25-9:27
 * @version: 1.0
 */
@WebServlet("/index")
public class IndexServlet extends ViewBaseServlet {

    private final FruitDAOImpl fruitDAO = new FruitDAOImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();

        int pageNo = 1;
        int size;
        List<Fruit> fruitList;
        String keyword;

        // 请求方式判断标识
        String operation = req.getParameter("operation");

        // 当前是在第几页
        String pageNoStr = req.getParameter("pageNo");
        if (!StringUtils.isEmpty(pageNoStr)) {
            pageNo = Integer.parseInt(pageNoStr);
        }

        /*
        如果operation是null则是get请求，
        否则就是post请求
         */
        if (!StringUtils.isEmpty(operation) && "search".equals(operation)) {
            // post请求处理表单
            keyword = req.getParameter("keyword");
            // 用户空输入判断
            if (StringUtils.isEmpty(keyword)) {
                keyword = "";
                size = fruitDAO.getFruitList().size();
                fruitList = fruitDAO.getFruitList(pageNo);
            } else {
                size = fruitDAO.getFruitList(keyword).size();
                fruitList = fruitDAO.getFruitList(keyword, pageNo);
            }
            // get请求.地址栏直接输入网址，上一页下一页
        } else {
            keyword = (String) session.getAttribute("keyword");
            if (StringUtils.isEmpty(keyword)) {
                size = fruitDAO.getFruitList().size();
                fruitList = fruitDAO.getFruitList(pageNo);
            } else {
                size = fruitDAO.getFruitList(keyword).size();
                fruitList = fruitDAO.getFruitList(keyword, pageNo);
            }
        }

        // 页面数量
        int pageCount = (size + 5 - 1) / 5;

        session.setAttribute("fruitList", fruitList);
        session.setAttribute("keyword", keyword);
        session.setAttribute("pageNo", pageNo);
        session.setAttribute("pageCount", pageCount);

        processTemplate("index", req, resp);

    }
}
