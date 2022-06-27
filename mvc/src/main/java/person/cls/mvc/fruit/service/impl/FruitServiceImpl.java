package person.cls.mvc.fruit.service.impl;

import person.cls.mvc.fruit.dao.FruitDAO;
import person.cls.mvc.fruit.pojo.Fruit;
import person.cls.mvc.fruit.service.FruitService;

import java.util.List;

/**
 * @description: 服务实现层
 * @author: CLS
 * @date: 2022-06-26-21:48
 * @version: 1.0
 */
public class FruitServiceImpl implements FruitService {

    private FruitDAO fruitDAO = null;

    @Override
    public List<Fruit> getFruitList() {
        return fruitDAO.getFruitList();
    }

    @Override
    public List<Fruit> getFruitList(Integer pageNo) {
        return fruitDAO.getFruitList(pageNo);
    }

    @Override
    public List<Fruit> getFruitList(String keyword) {
        return fruitDAO.getFruitList(keyword);
    }

    @Override
    public List<Fruit> getFruitList(String keyword, Integer pageNo) {
        return fruitDAO.getFruitList(keyword, pageNo);
    }

    @Override
    public Fruit getFruitInfo(Integer fid) {
        return fruitDAO.getFruitInfo(fid);
    }

    @Override
    public void updateFruitById(Fruit fruit) {
        fruitDAO.updateFruitById(fruit);
    }

    @Override
    public void delFruitById(Integer fid) {
        fruitDAO.delFruitById(fid);
    }

    @Override
    public void addFruit(Fruit fruit) {
        fruitDAO.addFruit(fruit);
    }
}
