package com.lihuanyu.dao;

import com.lihuanyu.model.Score;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Explorer on 2016/5/3.
 */
public interface ScoreDao extends CrudRepository<Score,Long> {
    Iterable<Score> findByCustomUserId(long customUserId);
}
