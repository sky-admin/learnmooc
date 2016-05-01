package com.lihuanyu.dto;

import java.util.ArrayList;

/**
 * Created by skyADMIN on 16/5/1.
 */
public class HistoryDate {

    public ArrayList<HistoryDateJson> historyDate;

    public class HistoryDateJson {
        public ArrayList<HistoryCourse> historyCourse;
        public String time;
    }

    public class HistoryCourse {
        public int courseId;
        public String courseName;
    }

}
