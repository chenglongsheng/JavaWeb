package person.cls.book.controller;

import person.cls.book.pojo.User;
import person.cls.book.service.UserService;

/**
 * @description: 用户控制器
 * @author: CLS
 * @date: 2022-07-09-14:46
 * @version: 1.0
 */
public class UserController {

    private UserService userService;

    public String login(String uname, String pwd) {
        User user = userService.login(uname, pwd);
        System.out.println("user = " + user);
        return "index";
    }

}
