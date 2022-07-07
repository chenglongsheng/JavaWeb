package person.cls.qqzone.controller;

import person.cls.qqzone.pojo.Reply;
import person.cls.qqzone.pojo.UserBasic;
import person.cls.qqzone.service.ReplyService;
import person.cls.qqzone.service.TopicService;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @description: 回复控制器
 * @author: CLS
 * @date: 2022-07-07-7:42
 * @version: 1.0
 */
public class ReplyController {

    private ReplyService replyService;
    private TopicService topicService;

    public String delReply(Integer replyId) {
        Reply reply = replyService.getReplyById(replyId);
        replyService.delReplyById(replyId);
        return "redirect:topic.do?operate=topicDetail&id=" + reply.getTopic().getId();
    }

    public String addReply(String content, Integer topicId, HttpSession session) {
        UserBasic userBasic = (UserBasic) session.getAttribute("userBasic");
        replyService.addReply(new Reply(content, new Date(), userBasic, topicService.geTopicById(topicId)));
        return "redirect:topic.do?operate=topicDetail&id=" + topicId;
    }

}
