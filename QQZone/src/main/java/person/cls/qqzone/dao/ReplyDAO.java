package person.cls.qqzone.dao;

import person.cls.qqzone.pojo.Reply;
import person.cls.qqzone.pojo.Topic;

import java.util.List;

/**
 * @description: 回复DAO层
 * @author: CLS
 * @date: 2022-07-05-8:23
 * @version: 1.0
 */
public interface ReplyDAO {

    /**
     * 获取指定日志的回复列表
     */
    List<Reply> getReplyList(Topic topic);

    Reply getReplyById(Integer id);

    /**
     * 添加回复
     */
    void addReply(Reply reply);

    /**
     * 删除回复
     */
    void delReply(Integer id);

}
