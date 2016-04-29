package com.lihuanyu.model;

import javax.persistence.*;

/**
 * Created by Explorer on 2016/4/29.
 */
@Entity
@Table(name = "t_collected_article")
public class CollectedArticle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long userId;
    private String artileList;//收藏的文章id列表  eg:1,5,3,10  使用时分隔字符串 转long

    public CollectedArticle() {

    }

    public CollectedArticle(long userId, String artileList) {
        this.userId = userId;
        this.artileList = artileList;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setArtileList(String artileList) {
        this.artileList = artileList;
    }

    public long getId() {
        return id;
    }

    public long getUserId() {
        return userId;
    }

    public String getArtileList() {
        return artileList;
    }
}
