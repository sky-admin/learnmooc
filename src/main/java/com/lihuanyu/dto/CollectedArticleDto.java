package com.lihuanyu.dto;

import java.util.ArrayList;

/**
 * Created by Explorer on 2016/5/3.
 */
public class CollectedArticleDto {

    public ArrayList<ListArticle> articleData;

    public class ListArticle {
        public String abstractInfo;
        public String classifyName;
        public String img;
        public String num;
        public String title;
        public String url;
    }
}
