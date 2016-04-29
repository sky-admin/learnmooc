package com.lihuanyu.model;

import javax.persistence.*;

/**
 * Created by Explorer on 2016/4/29.
 */
@Entity
@Table(name = "t_collected_course")
public class CollectedCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long userId;
    private String courseList;//收藏的课程id列表  eg:1,5,3,10  使用时分隔字符串 转long

    public CollectedCourse() {

    }

    public CollectedCourse(long userId, String courseList) {
        this.userId = userId;
        this.courseList = courseList;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setCourseList(String courseList) {
        this.courseList = courseList;
    }

    public long getId() {
        return id;
    }

    public long getUserId() {
        return userId;
    }

    public String getCourseList() {
        return courseList;
    }
}
