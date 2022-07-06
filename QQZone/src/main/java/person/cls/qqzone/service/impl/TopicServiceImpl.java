package person.cls.qqzone.service.impl;

import person.cls.qqzone.dao.TopicDAO;
import person.cls.qqzone.pojo.Reply;
import person.cls.qqzone.pojo.Topic;
import person.cls.qqzone.pojo.UserBasic;
import person.cls.qqzone.service.ReplyService;
import person.cls.qqzone.service.TopicService;

import java.util.List;

/**
 * @description: 日志Service实现层
 * @author: CLS
 * @date: 2022-07-05-9:29
 * @version: 1.0
 */
public class TopicServiceImpl implements TopicService {

    private TopicDAO topicDAO;
    private ReplyService replyService;

    @Override
    public List<Topic> getTopicList(UserBasic userBasic) {
        return topicDAO.getTopicList(userBasic);
    }

    @Override
    public Topic geTopicById(Integer id) {
        Topic topic = topicDAO.getTopic(new Topic(id));
        List<Reply> replyList = replyService.getReplyList(id);
        topic.setReplyList(replyList);
        return topic;
    }
}
