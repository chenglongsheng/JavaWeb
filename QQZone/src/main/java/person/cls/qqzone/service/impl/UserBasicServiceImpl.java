package person.cls.qqzone.service.impl;

import person.cls.qqzone.dao.UserBasicDAO;
import person.cls.qqzone.pojo.UserBasic;
import person.cls.qqzone.service.UserBasicService;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 用户信息Service实现层
 * @author: CLS
 * @date: 2022-07-05-8:56
 * @version: 1.0
 */
public class UserBasicServiceImpl implements UserBasicService {

    private UserBasicDAO userBasicDAO = null;

    @Override
    public UserBasic login(String loginId, String pwd) {
        return userBasicDAO.getUserBasic(loginId, pwd);
    }

    @Override
    public List<UserBasic> getFriendList(UserBasic userBasic) {
        List<UserBasic> friendIdList = userBasicDAO.getUserBasicList(userBasic);
        List<UserBasic> friendList = new ArrayList<>();
        friendIdList.forEach(item -> friendList.add(userBasicDAO.getUserBasicById(item.getId())));
        return friendList;
    }
}
