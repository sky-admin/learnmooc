package com.lihuanyu.service;

import com.lihuanyu.dao.HistoryDao;
import com.lihuanyu.model.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Iterator;

/**
 * Created by skyADMIN on 16/5/1.
 */
@Service
public class CourseService {

    @Autowired
    private HistoryDao historyDao;

    private Sort sortByIdDesc() {
        return new Sort(Sort.Direction.DESC, "createDate");
    }

    public void getHistoryCourse(long uid) {
        Iterable<History> histories = historyDao.findByCustomUserId(uid,sortByIdDesc());

    }

}
