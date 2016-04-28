package com.lihuanyu.service;

import com.lihuanyu.dao.ArticleDao;
import com.lihuanyu.dto.ArticleAll;
import com.lihuanyu.dto.ArticleList;
import com.lihuanyu.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * Created by skyADMIN on 16/4/26.
 */
@Service
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;

    private Sort sortByIdDesc() {
        return new Sort(Sort.Direction.DESC, "id");
    }

    private Sort sortByIdAsc() {
        return new Sort(Sort.Direction.ASC, "id");
    }

    public ArticleList getArticleList() {
        Iterable<Article> articles = articleDao.findAll(sortByIdDesc());
        ArticleList articleList = new ArticleList();
        articleList.articleData = articles;
        articleList.more = "/articleall";
        return articleList;
    }

    public ArticleAll getAllArticleList() {
        Iterable<Article> articles = articleDao.findAll(sortByIdDesc());
        ArticleAll articleAll = new ArticleAll();
        articleAll.articleData = articles;
        return articleAll;
    }
}
