package com.lihuanyu.dao;

import com.lihuanyu.model.CollectedArticle;
import com.lihuanyu.model.CollectedCourse;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by skyADMIN on 16/4/28.
 */
public interface CollectedArticleDao extends CrudRepository<CollectedArticle,Long>{
    public CollectedArticle findByUserId(long userId);
}
