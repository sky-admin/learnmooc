package com.lihuanyu.model;

import javax.persistence.*;

/**章
 * Created by Explorer on 2016/4/20.
 */
@Entity
@Table(name = "t_chapter")
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long courseId;//本章所属课程的id
    private String chapterName;//本章名称

    public Chapter(){}

    public Chapter(long courseId, String chapterName) {
        this.courseId = courseId;
        this.chapterName = chapterName;
    }


    public void setId(long id) {
        this.id = id;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public long getId() {
        return id;
    }

    public long getCourseId() {
        return courseId;
    }

    public String getChapterName() {
        return chapterName;
    }
}
