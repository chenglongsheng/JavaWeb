package person.cls.mvc.fruit.dao;

import person.cls.mvc.fruit.pojo.Fruit;

import java.util.List;

/**
 * @description: TODO
 * @author: CLS
 * @date: 2022-06-25-9:15
 * @version: 1.0
 */
public interface FruitDAO {

    // 查询所有库存列表
    List<Fruit> getFruitList();

    // 分页查询
    List<Fruit> getFruitList(Integer pageNo);

    // 模糊查询
    List<Fruit> getFruitList(String keyword);

    // 模糊分页查询
    List<Fruit> getFruitList(String keyword, Integer pageNo);

    // 根据id获取数据
    Fruit getFruitInfo(Integer fid);

    // 更新
    void updateFruitById(Fruit fruit);

    // 删除
    void delFruitById(Integer fid);

    // 添加
    void addFruit(Fruit fruit);

}
