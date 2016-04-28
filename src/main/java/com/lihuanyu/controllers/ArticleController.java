package com.lihuanyu.controllers;

import com.lihuanyu.dto.ArticleAll;
import com.lihuanyu.dto.ArticleList;
import com.lihuanyu.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by skyADMIN on 16/4/26.
 */
@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/articles")
    public ArticleList showAriticles(){
        return articleService.getArticleList();
    }

    @RequestMapping("/articleall")
    public ArticleAll showAllAritcles(){
        return articleService.getAllArticleList();
    }
}
