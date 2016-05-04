package com.lihuanyu.dao;

import com.lihuanyu.model.Article;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by skyADMIN on 16/4/26.
 */
public interface ArticleDao extends CrudRepository<Article, Long> {
    Iterable<Article> findAll(Sort orders);

    public Article findByArticleUrl(String articleUrl);
}
