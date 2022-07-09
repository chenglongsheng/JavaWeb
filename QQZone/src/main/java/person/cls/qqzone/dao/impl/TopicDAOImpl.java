package person.cls.qqzone.dao.impl;

import person.cls.qqzone.dao.TopicDAO;
import person.cls.myssm.basedao.BaseDAO;
import person.cls.qqzone.pojo.Topic;
import person.cls.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * @description: 日志DAO实现层
 * @author: CLS
 * @date: 2022-07-05-9:00
 * @version: 1.0
 */
public class TopicDAOImpl extends BaseDAO<Topic> implements TopicDAO {
    @Override
    public List<Topic> getTopicList(UserBasic userBasic) {
        return super.executeQuery("select * from t_topic where author=?", userBasic.getId());
    }

    @Override
    public void addTopic(Topic topic) {

    }

    @Override
    public void delTopic(Topic topic) {

    }

    @Override
    public Topic getTopic(Topic topic) {
        return super.load("select * from t_topic where id=?", topic.getId());
    }
}
