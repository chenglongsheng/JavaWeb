package person.cls.book.service.impl;

import person.cls.book.dao.UserDAO;
import person.cls.book.pojo.User;
import person.cls.book.service.UserService;

/**
 * @description: 用户服务实现
 * @author: CLS
 * @date: 2022-07-09-15:02
 * @version: 1.0
 */
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    @Override
    public User login(String uname, String pwd) {
        return userDAO.getUser(uname, pwd);
    }
}
