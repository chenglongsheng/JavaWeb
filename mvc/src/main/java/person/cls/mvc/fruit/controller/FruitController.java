package person.cls.mvc.fruit.controller;

import person.cls.mvc.fruit.dao.impl.FruitDAOImpl;
import person.cls.mvc.fruit.pojo.Fruit;
import person.cls.mvc.myssm.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @description: 合并增删改查的servlet
 * @author: CLS
 * @date: 2022-06-25-9:41
 * @version: 1.0
 */
public class FruitController {

    private final FruitDAOImpl fruitDAO = new FruitDAOImpl();

    protected String index(HttpServletRequest request) throws ServletException{

        HttpSession session = request.getSession();

        int pageNo = 1;
        int size;
        List<Fruit> fruitList;
        String keyword;

        // 请求方式判断标识
        String operation = request.getParameter("operation");

        // 当前是在第几页
        String pageNoStr = request.getParameter("pageNo");
        if (!StringUtils.isEmpty(pageNoStr)) {
            pageNo = Integer.parseInt(pageNoStr);
        }

        /*
        如果operation是null则是get请求，
        否则就是post请求
         */
        if (!StringUtils.isEmpty(operation) && "search".equals(operation)) {
            // post请求处理表单
            keyword = request.getParameter("keyword");
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

//        processTemplate("index", request, response);

        return "index";

    }

    protected String add(HttpServletRequest request) throws ServletException {

        String fname = request.getParameter("fname");
        Integer price = Integer.parseInt(request.getParameter("price"));
        Integer fcount = Integer.parseInt(request.getParameter("fcount"));
        String remark = request.getParameter("remark");

        Fruit fruit = new Fruit(0, fname, price, fcount, remark);
        fruitDAO.addFruit(fruit);

//        response.sendRedirect("fruit.do");
        return "redirect:fruit.do";

    }

    protected String del(HttpServletRequest request) throws ServletException {
        int fid = Integer.parseInt(request.getParameter("fid"));
        fruitDAO.delFruitById(fid);
//        response.sendRedirect("fruit.do");
        return "redirect:fruit.do";
    }

    protected String edit(HttpServletRequest request) throws ServletException {

        String fid = request.getParameter("fid");
        if (!StringUtils.isEmpty(fid)) {
            int id = Integer.parseInt(fid);
            Fruit fruitInfo = fruitDAO.getFruitInfo(id);
            request.setAttribute("fruit", fruitInfo);
//            processTemplate("edit", request, response);
            return "edit";
        }
        return "error";
    }

    protected String update(HttpServletRequest request) throws ServletException {

        String fidStr = request.getParameter("fid");
        Integer fid = Integer.parseInt(fidStr);
        String fname = request.getParameter("fname");
        String priceStr = request.getParameter("price");
        Integer price = Integer.parseInt(priceStr);
        String fcountStr = request.getParameter("fcount");
        Integer fcount = Integer.parseInt(fcountStr);
        String remark = request.getParameter("remark");

        Fruit fruit = new Fruit(fid, fname, price, fcount, remark);
        fruitDAO.updateFruitById(fruit);

        // 浏览器重定向
//        response.sendRedirect("fruit.do");
        return "redirect:fruit.do";

    }

}
