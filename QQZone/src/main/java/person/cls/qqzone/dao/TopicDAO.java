package person.cls.qqzone.dao;

import person.cls.qqzone.pojo.Topic;
import person.cls.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * @description: 日志DAO层
 * @author: CLS
 * @date: 2022-07-05-8:20
 * @version: 1.0
 */
public interface TopicDAO {

    /**
     * 获取指定用户的所有日志
     */
    List<Topic> getTopicList(UserBasic userBasic);

    /**
     * 添加日志
     */
    void addTopic(Topic topic);

    /**
     * 删除日志
     */
    void delTopic(Topic topic);

    /**
     * 获取特定日志信息
     */
    void getTopic(Topic topic);

}
