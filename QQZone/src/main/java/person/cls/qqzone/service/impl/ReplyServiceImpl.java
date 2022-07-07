package person.cls.qqzone.service.impl;

import person.cls.qqzone.dao.ReplyDAO;
import person.cls.qqzone.pojo.HostReply;
import person.cls.qqzone.pojo.Reply;
import person.cls.qqzone.pojo.Topic;
import person.cls.qqzone.pojo.UserBasic;
import person.cls.qqzone.service.HostReplyService;
import person.cls.qqzone.service.ReplyService;
import person.cls.qqzone.service.UserBasicService;

import java.util.List;

/**
 * @description: 回复服务实现类
 * @author: CLS
 * @date: 2022-07-06-14:36
 * @version: 1.0
 */
public class ReplyServiceImpl implements ReplyService {

    private ReplyDAO replyDAO;

    private HostReplyService hostReplyService;
    private UserBasicService userBasicService;

    @Override
    public List<Reply> getReplyList(Integer topicId) {
        List<Reply> replyList = replyDAO.getReplyList(new Topic(topicId));
        for (Reply reply : replyList) {
            UserBasic author = userBasicService.getUserBasicById(reply.getAuthor().getId());
            HostReply hostReply = hostReplyService.getHostReplyByReplyId(reply.getId());
            if (hostReply != null) {
                reply.setHostReply(hostReply);
            }
            reply.setAuthor(author);
        }
        return replyList;
    }

    @Override
    public void delReplyById(Integer replyId) {
        HostReply hostReply = hostReplyService.getHostReplyByReplyId(replyId);
        if (hostReply != null) {
            hostReplyService.delHostReplyById(hostReply.getId());
        }
        replyDAO.delReply(replyId);
    }

    @Override
    public Reply getReplyById(Integer replyId) {
        return replyDAO.getReplyById(replyId);
    }

}
