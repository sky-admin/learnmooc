package com.lihuanyu.dao;

import com.lihuanyu.model.Article;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by skyADMIN on 16/4/26.
 */
public interface ArticleDao extends CrudRepository<Article,Long> {
}
