package person.cls.qqzone.dao;

import person.cls.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * @description: 用户详细信息DAO层
 * @author: CLS
 * @date: 2022-07-05-8:15
 * @version: 1.0
 */
public interface UserBasicDAO {

    /**
     * 根据账号密码获取指定的用户信息
     */
    UserBasic getUserBasic(String loginId, String pwd);

    /**
     * 获取指定用户的所有好友列表id
     */
    List<UserBasic> getUserBasicList(UserBasic userBasic);

    /**
     * 根据id获取用户
     */
    UserBasic getUserBasicById(Integer id);

}
