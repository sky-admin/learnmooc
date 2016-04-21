package com.lihuanyu.model;

import javax.persistence.*;
import java.util.Date;

/**
 * 课程/实验
 * Created by Explorer on 2016/1/29.
 */
@Entity
@Table(name = "t_course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String course_name;
    private String description;//课程描述
    private String classification;//课程所属类别
    private int user_id;//创建课程的用户id
    private String user_name;//创建课程的用户名
    private String course_video_url;//课程视频的url
    private String thumbnail;//课程缩略图
    private int num;//学习人数
    private String classifyName;//所属类别 如：前端开发
    private boolean isRecommend;// true： 推荐课程/实验 会显示在首页的轮播种； false：默认是false
    private Date create_date;

    public Course() {
    }

    public Course(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public String getCourse_name() {
        return course_name;
    }

    public String getDescription() {
        return description;
    }

    public String getClassification() {
        return classification;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getCourse_video_url() {
        return course_video_url;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public int getNum() {
        return num;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setCourse_video_url(String course_video_url) {
        this.course_video_url = course_video_url;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }
}
