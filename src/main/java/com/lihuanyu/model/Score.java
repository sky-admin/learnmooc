package com.lihuanyu.model;

import javax.persistence.*;
import java.util.Date;

/**
 * 成绩
 * Created by Explorer on 2016/4/21.
 */
@Entity
@Table(name = "t_score")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long customUserId;//该成绩所属人的id
    private long courseOrExptId;//该成绩所属课程或实验的id
    private int scores;//成绩
    private Date createDate;


    public Score(){

    }

    public Score(long customUserId, long courseOrExptId, int scores) {
        this.customUserId = customUserId;
        this.courseOrExptId = courseOrExptId;
        this.scores = scores;
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

    public void setScores(int scores) {
        this.scores = scores;
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

    public int getScores() {
        return scores;
    }
}


