package com.lihuanyu.service;

import com.lihuanyu.dao.HistoryDao;
import com.lihuanyu.dto.HistoryDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Explorer on 2016/5/4.
 */
@Service
public class HistoryService {

    @Autowired
    private HistoryDao historyDao;

//    public HistoryDate getHistoryList(long userId){
//        historyDao.findByCustomUserId(userId);
//    }
}
