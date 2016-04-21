package com.lihuanyu.model;

import javax.persistence.*;
import java.util.Date;

/**
 * 选修记录
 * Created by Explorer on 2016/4/21.
 */
@Entity
@Table(name = "t_elective_log")
public class ElectiveLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long customUserId;//选修者的id
    private long courseOrExptId;//选修的课程或实验id
    private Date createDate;

    public ElectiveLog(long customUserId, long courseOrExptId, Date createDate) {
        this.customUserId = customUserId;
        this.courseOrExptId = courseOrExptId;
        this.createDate = createDate;
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

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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

    public Date getCreateDate() {
        return createDate;
    }
}
