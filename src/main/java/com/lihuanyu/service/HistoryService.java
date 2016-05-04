package com.lihuanyu.service;

import com.lihuanyu.dao.HistoryDao;
import com.lihuanyu.dto.HistoryDate;
import com.lihuanyu.model.History;
import com.lihuanyu.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Explorer on 2016/5/4.
 */
@Service
public class HistoryService {

    @Autowired
    private HistoryDao historyDao;

    private Sort sortByCreateDateDesc() {
        return new Sort(Sort.Direction.DESC, "createDate");
    }

    public HistoryDate getHistoryList(long userId){
        Iterable<History> histories = historyDao.findByCustomUserId(userId,sortByCreateDateDesc());
        HistoryDate historyDate = new HistoryDate();
        historyDate.historyDate = new ArrayList<>();

        HistoryDate.HistoryDateJson historyDateJson = new HistoryDate().new HistoryDateJson();
        Date temp = null;

        for (History history:histories){
            if (null == temp){
                temp = history.getCreateDate();
                historyDateJson.time = history.getCreateDate().toString();
                historyDateJson.historyCourse = new ArrayList<>();
                HistoryDate.HistoryCourse historyCourse = new HistoryDate().new HistoryCourse();
                historyCourse.courseId = (int) history.getId();
                historyCourse.courseName = history.getCourseOrExptName();
                historyDateJson.historyCourse.add(historyCourse);
            }else if (DateUtils.sameDay(temp,history.getCreateDate())){
                HistoryDate.HistoryCourse historyCourse = new HistoryDate().new HistoryCourse();
                historyCourse.courseId = (int) history.getId();
                historyCourse.courseName = history.getCourseOrExptName();
                historyDateJson.historyCourse.add(historyCourse);
            }else {
                historyDate.historyDate.add(historyDateJson);
                historyDateJson = new HistoryDate().new HistoryDateJson();
                temp = history.getCreateDate();
                historyDateJson.time = history.getCreateDate().toString();
                historyDateJson.historyCourse = new ArrayList<>();
                HistoryDate.HistoryCourse historyCourse = new HistoryDate().new HistoryCourse();
                historyCourse.courseId = (int) history.getId();
                historyCourse.courseName = history.getCourseOrExptName();
                historyDateJson.historyCourse.add(historyCourse);
            }
        }
        historyDate.historyDate.add(historyDateJson);
        return historyDate;
    }

}
