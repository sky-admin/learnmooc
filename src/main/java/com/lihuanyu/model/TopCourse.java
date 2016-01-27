package com.lihuanyu.model;

import javax.persistence.*;

/**
 * Created by skyADMIN on 16/1/27.
 */
@Entity
@Table(name = "t_course")
public class TopCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String course_name;
    private String description;
    private int user_id;
    private String user_name;
    private int num;
    private String course_video_url;
    private String thumbnail;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getCourse_video_url() {
        return course_video_url;
    }

    public void setCourse_video_url(String course_video_url) {
        this.course_video_url = course_video_url;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
