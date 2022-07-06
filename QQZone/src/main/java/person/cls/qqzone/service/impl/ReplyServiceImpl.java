package person.cls.qqzone.service.impl;

import person.cls.qqzone.dao.ReplyDAO;
import person.cls.qqzone.pojo.Reply;
import person.cls.qqzone.pojo.Topic;
import person.cls.qqzone.service.HostReplyService;
import person.cls.qqzone.service.ReplyService;

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

    @Override
    public List<Reply> getReplyList(Integer topicId) {
        List<Reply> replyList = replyDAO.getReplyList(new Topic(topicId));
        for (Reply reply : replyList) {
            reply.setHostReply(hostReplyService.getHostReplyByReplyId(reply.getId()));
        }
        return replyList;
    }
}
