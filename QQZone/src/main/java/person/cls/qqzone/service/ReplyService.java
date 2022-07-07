package person.cls.qqzone.service;

import person.cls.qqzone.pojo.Reply;

import java.util.List;

/**
 * @description: 回复服务接口
 * @author: CLS
 * @date: 2022-07-06-14:35
 * @version: 1.0
 */
public interface ReplyService {

    List<Reply> getReplyList(Integer topicId);

    void delReplyById(Integer replyId);

    Reply getReplyById(Integer replyId);
}
