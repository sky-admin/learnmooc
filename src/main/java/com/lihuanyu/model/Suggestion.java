package com.lihuanyu.model;

import javax.persistence.*;

/**
 * 意见反馈
 * Created by Explorer on 2016/4/21.
 */
@Entity
@Table(name = "t_suggestion")
public class Suggestion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String content;
    private long customUserId;//反馈者id

    public Suggestion(String content, long customUserId) {
        this.content = content;
        this.customUserId = customUserId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCustomUserId(long customUserId) {
        this.customUserId = customUserId;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public long getCustomUserId() {
        return customUserId;
    }
}

