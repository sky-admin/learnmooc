package com.lihuanyu.dao;

import com.lihuanyu.model.Chapter;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by skyADMIN on 16/4/28.
 */
public interface ChapterDao extends CrudRepository<Chapter,Long>{
    public Iterable<Chapter> findByCourseId(long courseId);
}
