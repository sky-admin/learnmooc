package com.lihuanyu.model;

import javax.persistence.*;
import java.util.Date;

/**
 * 学习的历史记录
 * Created by Explorer on 2016/4/21.
 */
@Entity
@Table(name = "t_history")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long customUserId;//该条学习历史所有者id
    private long courseOrExptId;//学习的课程/实验名id
    private String courseOrExptName;//学习的课程/实验名
    private Date createDate;

    public History(){}

    public History(long customUserId, long courseOrExptId, String courseOrExptName, Date createDate) {
        this.customUserId = customUserId;
        this.courseOrExptId = courseOrExptId;
        this.courseOrExptName = courseOrExptName;
        this.createDate = createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCustomUserId(long customUserId) {
        this.customUserId = customUserId;
    }

    public void setCourseOrExptId(long courseOrExptId) {
        this.courseOrExptId = courseOrExptId;
    }

    public void setCourseOrExptName(String courseOrExptName) {
        this.courseOrExptName = courseOrExptName;
    }

    public long getId() {
        return id;
    }

    public long getCustomUserId() {
        return customUserId;
    }

    public long getCourseOrExptId() {
        return courseOrExptId;
    }

    public String getCourseOrExptName() {
        return courseOrExptName;
    }
}
