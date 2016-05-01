package com.lihuanyu.model;

import javax.persistence.*;
import java.util.Date;

/**
 * 评论
 * Created by Explorer on 2016/4/20.
 */
@Entity
@Table(name = "t_comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String commentContent;//评论内容
    private long fromUserId;//评论者的Id
    private long courseId;//评论所属课程的id
    private Date create_date;

    public Comment() {
    }

    public Comment(long id) {
        this.id = id;
    }

    public Comment(String commentContent, long fromUserId, long courseId, Date create_date) {
        this.commentContent = commentContent;
        this.fromUserId = fromUserId;
        this.courseId = courseId;
        this.create_date = create_date;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public void setFromUserId(long fromUserId) {
        this.fromUserId = fromUserId;
    }

    public long getId() {
        return id;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public long getFromUserId() {
        return fromUserId;
    }
}
