package com.lihuanyu.service;

import com.lihuanyu.dao.ArticleDao;
import com.lihuanyu.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;

/**
 * Created by skyADMIN on 16/4/26.
 */
@Service
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;

    public void getArticleList() {
        Iterable<Article> articles = articleDao.findAll();
        Iterator articleIterator = articles.iterator();

    }
}
