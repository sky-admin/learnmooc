package com.lihuanyu.dto;

import java.util.ArrayList;

/**
 * Created by Explorer on 2016/5/3.
 */
public class ScoreDto {

    public ArrayList<scoreInfo> scoreList;

    public class scoreInfo {
        public String courseName;
        public int scores;
    }
}
