package person.cls.thymeleaf.fruit.dao.impl;

import person.cls.thymeleaf.fruit.dao.FruitDAO;
import person.cls.thymeleaf.fruit.dao.base.BaseDAO;
import person.cls.thymeleaf.fruit.pojo.Fruit;

import java.util.List;

/**
 * @description: Fruit实现类
 * @author: CLS
 * @date: 2022-06-14-9:26
 * @version: 1.0
 */
public class FruitDAOImpl extends BaseDAO<Fruit> implements FruitDAO {
    @Override
    public List<Fruit> getFruitList() {
        return super.executeQuery("select * from t_fruit");
    }
}
