package com.lihuanyu.dto;

import java.util.ArrayList;

/**
 * Created by Explorer on 2016/5/4.
 */
public class SearchResultDto {
    public ArrayList<SearchInfo> searchResult;

    public class SearchInfo {
        public long courseId;
        public String courseName;
        public int num;
        public String thumbnailUrl;
        public String pubdate;
    }
}
