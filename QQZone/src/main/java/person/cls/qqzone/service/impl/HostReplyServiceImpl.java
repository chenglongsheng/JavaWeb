package person.cls.qqzone.service.impl;

import person.cls.qqzone.dao.HostReplyDAO;
import person.cls.qqzone.pojo.HostReply;
import person.cls.qqzone.service.HostReplyService;

/**
 * @description: 主人回复实现类
 * @author: CLS
 * @date: 2022-07-06-14:48
 * @version: 1.0
 */
public class HostReplyServiceImpl implements HostReplyService {

    private HostReplyDAO hostReplyDAO;

    @Override
    public HostReply getHostReplyByReplyId(Integer replyId) {
        return hostReplyDAO.getHostReplyByReplyId(replyId);
    }

}
