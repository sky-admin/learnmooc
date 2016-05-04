package com.lihuanyu.model;

import javax.persistence.*;
import java.util.Date;

/**
 * 笔记
 * Created by Explorer on 2016/4/20.
 */
@Entity
@Table(name = "t_note")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long customUserId;//笔记所有者id
    private String noteContent;//笔记内容
    private String courseOrExptName;//该笔记对应的课程/实验
    private Date createDate;

    public Note(){};

    public Note(long customUserId, String noteContent, String courseOrExptName, Date createDate) {
        this.customUserId = customUserId;
        this.noteContent = noteContent;
        this.courseOrExptName = courseOrExptName;
        this.createDate = createDate;
    }

    public void setCourseOrExptName(String courseOrExptName) {
        this.courseOrExptName = courseOrExptName;
    }

    public String getCourseOrExptName() {
        return courseOrExptName;
    }

    public void setCustomUserId(long customUserId) {
        this.customUserId = customUserId;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public long getCustomUserId() {
        return customUserId;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public Date getCreateDate() {
        return createDate;
    }
}
