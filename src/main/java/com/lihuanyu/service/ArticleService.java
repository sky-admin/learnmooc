package com.lihuanyu.service;

import com.lihuanyu.dao.ArticleDao;
import com.lihuanyu.dao.CollectedArticleDao;
import com.lihuanyu.dto.ArticleAll;
import com.lihuanyu.dto.ArticleList;
import com.lihuanyu.dto.CollectedArticleDto;
import com.lihuanyu.model.Article;
import com.lihuanyu.model.CollectedArticle;
import com.lihuanyu.model.CollectedCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by skyADMIN on 16/4/26.
 */
@Service
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private CollectedArticleDao collectedArticleDao;

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

    public void setCollection(long userId, String url) {
        CollectedArticle collectedList = collectedArticleDao.findByUserId(userId);
        if (collectedList == null) {
            collectedList = new CollectedArticle(userId, url);
            collectedArticleDao.save(collectedList);
        } else {
            String artileList = collectedList.getArtileList();
            StringBuilder builder = new StringBuilder(artileList);
            builder.insert(0, url + ";");
            collectedList.setArtileList(builder.toString());
            collectedArticleDao.save(collectedList);
        }
    }

    public void removeCollection(long userId, String url) {
        CollectedArticle collectedArticle = collectedArticleDao.findByUserId(userId);
        if (collectedArticle != null) {
            String artileList = collectedArticle.getArtileList();
            if (artileList.contains(";")) {
                artileList = artileList.replace(url + ";", "");
            } else {
                artileList = artileList.replace(url, "");
            }
            collectedArticle.setArtileList(artileList);
            collectedArticleDao.save(collectedArticle);
        }
    }

    public CollectedArticleDto getCollectedArticle(long userId) {
        CollectedArticle collectedArticle = collectedArticleDao.findByUserId(userId);
        String artileList = collectedArticle.getArtileList();
        String[] urlList = artileList.split(";");

        ArrayList<CollectedArticleDto.ListArticle> list = new ArrayList<>();
        for (int i = 0; i < urlList.length; i++) {
            CollectedArticleDto.ListArticle listArticle = new CollectedArticleDto().new ListArticle();
            Article article = articleDao.findByArticleUrl(urlList[i]);
            listArticle.abstractInfo = article.getAbstractInfo();
            listArticle.classifyName = article.getClassifyName();
            listArticle.img = article.getImg();
            listArticle.num = article.getNum() + "";
            listArticle.title = article.getTitle();
            listArticle.url = article.getArticleUrl();
            list.add(listArticle);
        }
        CollectedArticleDto collectedArticleDto = new CollectedArticleDto();
        collectedArticleDto.articleData = list;
        return collectedArticleDto;
    }
}
