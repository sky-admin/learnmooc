package com.lihuanyu.dao;

import com.lihuanyu.model.Course;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Explorer on 2016/1/29.
 */
@Transactional
public interface CourseDao extends CrudRepository<Course,Long> {
//    public Course findbyId(long id);
    public Iterable<Course> findByIsRecommend(boolean isRecommend);
    public Iterable<Course> findAll(Sort orders);
}
