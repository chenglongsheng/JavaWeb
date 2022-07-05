package person.cls.qqzone.dao.impl;

import person.cls.qqzone.dao.ReplyDAO;
import person.cls.qqzone.myssm.basedao.BaseDAO;
import person.cls.qqzone.pojo.Reply;
import person.cls.qqzone.pojo.Topic;

import java.util.List;

/**
 * @description: 回复DAO实现层
 * @author: CLS
 * @date: 2022-07-05-9:04
 * @version: 1.0
 */
public class ReplyDAOImpl extends BaseDAO<Reply> implements ReplyDAO {
    @Override
    public List<Reply> getReplyList(Topic topic) {
        return super.executeQuery("");
    }

    @Override
    public void addReply(Reply reply) {

    }

    @Override
    public void delReply(Integer id) {

    }
}
