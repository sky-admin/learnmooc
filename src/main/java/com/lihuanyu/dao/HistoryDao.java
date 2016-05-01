package com.lihuanyu.dao;

import com.lihuanyu.model.History;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by skyADMIN on 16/5/1.
 */
public interface HistoryDao extends CrudRepository<History, Long> {
    public Iterable<History> findByCustomUserId(long customUserId, Sort orders);
}
