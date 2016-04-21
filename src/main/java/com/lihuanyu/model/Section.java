package com.lihuanyu.model;

import javax.persistence.*;

/**
 * 节
 * Created by Explorer on 2016/4/20.
 */
@Entity
@Table(name = "t_section")
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long chapterId;//本节所属 章 的id
    private String sectionContent;//节内容（使用分号 ;隔开）

    public Section(long chapterId, String sectionContent) {
        this.chapterId = chapterId;
        this.sectionContent = sectionContent;
    }


    public void setChapterId(long chapterId) {
        this.chapterId = chapterId;
    }

    public void setSectionContent(String sectionContent) {
        this.sectionContent = sectionContent;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public long getChapterId() {
        return chapterId;
    }

    public String getSectionContent() {
        return sectionContent;
    }
}
