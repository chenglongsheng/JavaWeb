package person.cls.qqzone.service;

import person.cls.qqzone.pojo.HostReply;

/**
 * @description: 主人回复服务接口
 * @author: CLS
 * @date: 2022-07-06-14:46
 * @version: 1.0
 */
public interface HostReplyService {

    HostReply getHostReplyByReplyId(Integer replyId);

}
