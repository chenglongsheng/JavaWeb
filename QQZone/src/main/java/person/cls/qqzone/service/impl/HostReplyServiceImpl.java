package person.cls.qqzone.service.impl;

import person.cls.qqzone.dao.HostReplyDAO;
import person.cls.qqzone.pojo.HostReply;
import person.cls.qqzone.pojo.UserBasic;
import person.cls.qqzone.service.HostReplyService;
import person.cls.qqzone.service.UserBasicService;

/**
 * @description: 主人回复实现类
 * @author: CLS
 * @date: 2022-07-06-14:48
 * @version: 1.0
 */
public class HostReplyServiceImpl implements HostReplyService {

    private HostReplyDAO hostReplyDAO;
    private UserBasicService userBasicService;

    @Override
    public HostReply getHostReplyByReplyId(Integer replyId) {
        HostReply hostReply = hostReplyDAO.getHostReplyByReplyId(replyId);
        if (hostReply != null) {
            UserBasic author = userBasicService.getUserBasicById(hostReply.getAuthor().getId());
            hostReply.setAuthor(author);
        }
        return hostReply;
    }

}
