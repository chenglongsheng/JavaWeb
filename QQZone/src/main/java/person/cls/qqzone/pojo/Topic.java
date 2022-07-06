package person.cls.qqzone.pojo;

import java.util.Date;
import java.util.List;

/**
 * @description: 话题表
 * @author: CLS
 * @date: 2022-07-03-10:44
 * @version: 1.0
 */
public class Topic {

    private Integer id;
    private String title;
    private String content;
    private Date topicDate;
    private UserBasic author;

    private List<Reply> replyList;

    public Topic() {
    }

    public Topic(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTopicDate() {
        return topicDate;
    }

    public void setTopicDate(Date topicDate) {
        this.topicDate = topicDate;
    }

    public UserBasic getAuthor() {
        return author;
    }

    public void setAuthor(UserBasic author) {
        this.author = author;
    }

    public List<Reply> getReplyList() {
        return replyList;
    }

    public void setReplyList(List<Reply> replyList) {
        this.replyList = replyList;
    }
}
