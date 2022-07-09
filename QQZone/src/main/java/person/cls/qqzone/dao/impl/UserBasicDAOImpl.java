package person.cls.qqzone.dao.impl;

import person.cls.qqzone.dao.UserBasicDAO;
import person.cls.myssm.basedao.BaseDAO;
import person.cls.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * @description: UserBasicDAO实现层
 * @author: CLS
 * @date: 2022-07-05-8:27
 * @version: 1.0
 */
public class UserBasicDAOImpl extends BaseDAO<UserBasic> implements UserBasicDAO {
    @Override
    public UserBasic getUserBasic(String loginId, String pwd) {
        return super.load("select * from t_user_basic where loginId = ? and pwd = ?", loginId, pwd);
    }

    @Override
    public List<UserBasic> getUserBasicList(UserBasic userBasic) {
        return super.executeQuery("select fid as id from t_friend WHERE uid=?", userBasic.getId());
    }

    @Override
    public UserBasic getUserBasicById(Integer id) {
        return super.load("select * from t_user_basic where id = ?", id);
    }
}
