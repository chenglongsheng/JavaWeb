package person.cls.qqzone.dao;

import person.cls.qqzone.pojo.HostReply;

/**
 * @description: 主人回复DAO接口
 * @author: CLS
 * @date: 2022-07-06-14:43
 * @version: 1.0
 */
public interface HostReplyDAO {

    HostReply getHostReplyByReplyId(Integer replyId);

}
