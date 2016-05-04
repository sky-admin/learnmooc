package com.lihuanyu.controllers;

import com.lihuanyu.dto.ArticleAll;
import com.lihuanyu.dto.ArticleList;
import com.lihuanyu.dto.CollectedArticleDto;
import com.lihuanyu.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by skyADMIN on 16/4/26.
 */
@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/articles")
    public ArticleList showAriticles() {
        return articleService.getArticleList();
    }

    @RequestMapping("/articleall")
    public ArticleAll showAllAritcles() {
        return articleService.getAllArticleList();
    }

    @RequestMapping(value = "/article_collection")
    public String saveCollection(long userId, String url) {
        articleService.setCollection(userId, url);
        return "success";
    }

    @RequestMapping(value = "/remove_collection")
    public String removeCollection(long userId, String url) {
        articleService.removeCollection(userId, url);
        return "success";
    }

    @RequestMapping(value = "/has_collected_article", method = RequestMethod.GET)
    public CollectedArticleDto getCollectedArticle(long userId) {
        return articleService.getCollectedArticle(userId);
    }

    @RequestMapping(value = "/self_article", method = RequestMethod.GET)
    public CollectedArticleDto getSelfArticle(long userId) {
        CollectedArticleDto collectedArticleDto = new CollectedArticleDto();
        return collectedArticleDto;
    }
}
