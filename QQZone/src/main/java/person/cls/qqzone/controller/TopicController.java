package person.cls.qqzone.controller;

import person.cls.qqzone.pojo.Topic;
import person.cls.qqzone.service.TopicService;

import javax.servlet.http.HttpSession;

/**
 * @description: 日志控制器
 * @author: CLS
 * @date: 2022-07-06-14:24
 * @version: 1.0
 */
public class TopicController {

    private TopicService topicService;

    public String topicDetail(Integer id, HttpSession session) {
        Topic topic = topicService.geTopicById(id);
        session.setAttribute("topic", topic);
        return "frames/detail";
    }

}
