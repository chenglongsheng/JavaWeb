package person.cls.qqzone.service;

import person.cls.qqzone.pojo.Topic;
import person.cls.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * @description: 日志Service实现层
 * @author: CLS
 * @date: 2022-07-05-9:28
 * @version: 1.0
 */
public interface TopicService {

    /**
     * 获取特定用户的日志列表
     *
     * @param userBasic 特定用户
     * @return 用户的所有日志
     */
    List<Topic> getTopicList(UserBasic userBasic);

    Topic geTopicById(Integer id);

}
