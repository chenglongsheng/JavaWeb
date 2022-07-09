package person.cls.book.dao;

import person.cls.book.pojo.User;

/**
 * @description: 用户DAO接口
 * @author: CLS
 * @date: 2022-07-09-14:49
 * @version: 1.0
 */
public interface UserDAO {

    User getUser(String uname, String pwd);

}
