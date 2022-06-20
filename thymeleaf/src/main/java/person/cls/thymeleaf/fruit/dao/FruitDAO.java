package person.cls.thymeleaf.fruit.dao;

import person.cls.thymeleaf.fruit.pojo.Fruit;

import java.util.List;

/**
 * @description: fruit接口
 * @author: CLS
 * @date: 2022-06-14-9:24
 * @version: 1.0
 */
public interface FruitDAO {

    // 查询所有库存列表
    List<Fruit> getFruitList();

    // 根据id获取数据
    Fruit getFruitInfo(Integer fid);

    // 更新
    void updateFruitById(Fruit fruit);

    // 删除
    void delFruitById(Integer fid);

    // 添加
    void addFruit(Fruit fruit);

}
