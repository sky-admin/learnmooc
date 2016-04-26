package com.lihuanyu.service;

import com.lihuanyu.dao.ArticleDao;
import com.lihuanyu.dto.ArticleList;
import com.lihuanyu.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by skyADMIN on 16/4/26.
 */
@Service
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;

    public ArticleList getArticleList() {
        Iterable<Article> articles = articleDao.findAll();
        ArticleList articleList = new ArticleList();
        articleList.articleData = articles;
        articleList.more = "/articlelistall";
        return articleList;
    }
}
