package person.cls.mvc.fruit.controller;

import person.cls.mvc.fruit.pojo.Fruit;
import person.cls.mvc.fruit.service.impl.FruitServiceImpl;
import person.cls.mvc.myssm.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @description: 将servlet抽取出，变成一个纯类
 * @author: CLS
 * @date: 2022-06-25-9:41
 * @version: 2.0
 */
public class FruitController {

    private final FruitServiceImpl fruitService = new FruitServiceImpl();

    protected String index(Integer pageNo, String keyword, String operation, HttpServletRequest request) throws ServletException {

        HttpSession session = request.getSession();

        if (pageNo == null) {
            pageNo = 1;
        }
        List<Fruit> fruitList;
        int size;

        /*
        如果operation是null则是get请求，
        否则就是post请求
         */
        if (!StringUtils.isEmpty(operation) && "search".equals(operation)) {
            // post请求处理表单
            // 用户空输入判断
            if (StringUtils.isEmpty(keyword)) {
                keyword = "";
                size = fruitService.getFruitList().size();
                fruitList = fruitService.getFruitList(pageNo);
            } else {
                size = fruitService.getFruitList(keyword).size();
                fruitList = fruitService.getFruitList(keyword, pageNo);
            }
            // get请求.地址栏直接输入网址，上一页下一页
        } else {
            keyword = (String) session.getAttribute("keyword");
            if (StringUtils.isEmpty(keyword)) {
                size = fruitService.getFruitList().size();
                fruitList = fruitService.getFruitList(pageNo);
            } else {
                size = fruitService.getFruitList(keyword).size();
                fruitList = fruitService.getFruitList(keyword, pageNo);
            }
        }

        // 页面数量
        int pageCount = (size + 5 - 1) / 5;

        session.setAttribute("fruitList", fruitList);
        session.setAttribute("keyword", keyword);
        session.setAttribute("pageNo", pageNo);
        session.setAttribute("pageCount", pageCount);
        return "index";

    }

    protected String add(String fname, Integer price, Integer fcount, String remark) {
        Fruit fruit = new Fruit(0, fname, price, fcount, remark);
        fruitService.addFruit(fruit);
        return "redirect:fruit.do";
    }

    protected String del(Integer fid) throws ServletException {
        fruitService.delFruitById(fid);
        return "redirect:fruit.do";
    }

    protected String edit(HttpServletRequest request, Integer fid) {
        if (fid != null) {
            Fruit fruitInfo = fruitService.getFruitInfo(fid);
            request.setAttribute("fruit", fruitInfo);
            return "edit";
        }
        return "error";
    }

    protected String update(Integer fid, String fname, Integer price, Integer fcount, String remark) {
        Fruit fruit = new Fruit(fid, fname, price, fcount, remark);
        fruitService.updateFruitById(fruit);
        return "redirect:fruit.do";
    }

}
