package person.cls.mvc.fruit.dao.impl;

import person.cls.mvc.fruit.dao.FruitDAO;
import person.cls.mvc.fruit.pojo.Fruit;
import person.cls.mvc.myssm.basedao.BaseDAO;

import java.util.List;

/**
 * @description: TODO
 * @author: CLS
 * @date: 2022-06-25-9:16
 * @version: 1.0
 */
public class FruitDAOImpl extends BaseDAO<Fruit> implements FruitDAO {
    @Override
    public List<Fruit> getFruitList() {
        return super.executeQuery("select * from t_fruit");
    }

    @Override
    public List<Fruit> getFruitList(Integer pageNo) {
        return super.executeQuery("select * from t_fruit limit ?, 5", (pageNo - 1) * 5);
    }

    @Override
    public List<Fruit> getFruitList(String keyword) {
        return super.executeQuery("select * from t_fruit where fname like ? or remark like ?", "%" + keyword + "%", "%" + keyword + "%");
    }

    @Override
    public List<Fruit> getFruitList(String keyword, Integer pageNo) {
        return super.executeQuery("select * from t_fruit where fname like ? or remark like ? limit ?, 5", "%" + keyword + "%", "%" + keyword + "%", (pageNo - 1) * 5);
    }

    @Override
    public Fruit getFruitInfo(Integer fid) {
        return super.load("select * from t_fruit where fid=?", fid);
    }

    @Override
    public void updateFruitById(Fruit fruit) {
        String sql = "update t_fruit set fname = ?, price = ?, fcount = ?, remark = ? where fid = ?";
        executeUpdate(sql, fruit.getFname(), fruit.getPrice(), fruit.getFcount(), fruit.getRemark(), fruit.getFid());
    }

    @Override
    public void delFruitById(Integer fid) {
        super.executeUpdate("delete from t_fruit where fid=?", fid);
    }

    @Override
    public void addFruit(Fruit fruit) {
        String sql = "insert into t_fruit values (0,?,?,?,?)";
        super.executeUpdate(sql, fruit.getFname(), fruit.getPrice(), fruit.getFcount(), fruit.getRemark());
    }
}
