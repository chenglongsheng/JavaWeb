package person.cls.book.dao.impl;

import person.cls.book.dao.UserDAO;
import person.cls.book.pojo.User;
import person.cls.myssm.basedao.BaseDAO;

/**
 * @description: 用户DAO实现
 * @author: CLS
 * @date: 2022-07-09-14:50
 * @version: 1.0
 */
public class UserDAOImpl extends BaseDAO<User> implements UserDAO {
    @Override
    public User getUser(String uname, String pwd) {
        return super.load("select * from t_user where uname=? and pwd=?", uname, pwd);
    }
}
