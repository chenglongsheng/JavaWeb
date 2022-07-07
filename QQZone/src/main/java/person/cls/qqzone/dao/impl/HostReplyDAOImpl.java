package person.cls.qqzone.dao.impl;

import person.cls.qqzone.dao.HostReplyDAO;
import person.cls.qqzone.myssm.basedao.BaseDAO;
import person.cls.qqzone.pojo.HostReply;

/**
 * @description: 主人回复DAO实现类
 * @author: CLS
 * @date: 2022-07-06-14:43
 * @version: 1.0
 */
public class HostReplyDAOImpl extends BaseDAO<HostReply> implements HostReplyDAO {
    @Override
    public HostReply getHostReplyByReplyId(Integer replyId) {
        return load("select * from t_host_reply where reply=?", replyId);
    }

    @Override
    public void delHostReplyById(Integer id) {
        executeUpdate("delete from t_host_reply where id=?", id);
    }
}
