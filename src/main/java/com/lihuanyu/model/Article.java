package com.lihuanyu.model;

import javax.persistence.*;

/**
 * Created by Explorer on 2016/4/20.
 */
@Entity
@Table(name = "t_article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;//文章标题
    private String classifyName;//文章所属分类名称
    private int num;//阅读人数
    private String img;//文章图片地址  没有就使用默认图片http://120.27.47.134/article/img_artilce.jpg
    private String articleUrl;//文章链接

    public Article(String title, String articleUrl) {
        this.title = title;
        this.articleUrl = articleUrl;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public int getNum() {
        return num;
    }

    public String getImg() {
        return img;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArticleUrl(String articleUrl) {
        this.articleUrl = articleUrl;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getArticleUrl() {
        return articleUrl;
    }
}
