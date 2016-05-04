package com.lihuanyu.dao;

import com.lihuanyu.model.Chapter;
import com.lihuanyu.model.CollectedCourse;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by skyADMIN on 16/4/28.
 */
public interface CollectedCourseDao extends CrudRepository<CollectedCourse,Long>{
    public CollectedCourse findByUserId(long userId);
}
