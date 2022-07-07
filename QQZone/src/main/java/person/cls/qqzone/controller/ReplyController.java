package person.cls.qqzone.controller;

import person.cls.qqzone.pojo.Reply;
import person.cls.qqzone.service.ReplyService;

/**
 * @description: 回复控制器
 * @author: CLS
 * @date: 2022-07-07-7:42
 * @version: 1.0
 */
public class ReplyController {

    private ReplyService replyService;

    public String delReply(Integer replyId) {
        Reply reply = replyService.getReplyById(replyId);
        replyService.delReplyById(replyId);
        return "redirect:topic.do?operate=topicDetail&id=" + reply.getTopic().getId();
    }

}
