package person.cls.qqzone.controller;

import person.cls.qqzone.pojo.Topic;
import person.cls.qqzone.pojo.UserBasic;
import person.cls.qqzone.service.TopicService;
import person.cls.qqzone.service.UserBasicService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @description: 用户控制器
 * @author: CLS
 * @date: 2022-07-05-9:46
 * @version: 1.0
 */
public class UserController {

    private UserBasicService userBasicService;
    private TopicService topicService;

    public String login(String loginId, String pwd, HttpSession session) {
        UserBasic userBasic = userBasicService.login(loginId, pwd);
        if (userBasic != null) {
            List<UserBasic> friendList = userBasicService.getFriendList(userBasic);
            List<Topic> topicList = topicService.getTopicList(userBasic);
            userBasic.setFriendList(friendList);
            userBasic.setTopicList(topicList);
            session.setAttribute("userBasic", userBasic);
            return "index";
        } else {
            return "login";
        }
    }

}
