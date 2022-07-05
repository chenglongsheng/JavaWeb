package person.cls.qqzone.service;

import person.cls.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * @description: 用户信息Service实现层
 * @author: CLS
 * @date: 2022-07-05-8:56
 * @version: 1.0
 */
public interface UserBasicService {

    /**
     * 用户登录
     *
     * @param loginId 账号
     * @param pwd     密码
     * @return 登录的用户信息
     */
    UserBasic login(String loginId, String pwd);

    /**
     * 获取好友列表
     *
     * @param userBasic 登录的用户
     * @return 登录用户的好友列表
     */
    List<UserBasic> getFriendList(UserBasic userBasic);

}
