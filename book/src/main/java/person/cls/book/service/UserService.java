package person.cls.book.service;

import person.cls.book.pojo.User;

/**
 * @description: 用户服务接口
 * @author: CLS
 * @date: 2022-07-09-15:02
 * @version: 1.0
 */
public interface UserService {

    User login(String uname, String pwd);

}
