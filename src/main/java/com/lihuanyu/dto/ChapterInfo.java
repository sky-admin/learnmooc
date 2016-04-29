package com.lihuanyu.dto;

import java.util.ArrayList;

/**
 * Created by skyADMIN on 16/4/28.
 */
public class ChapterInfo {

    public ArrayList<ChapterInfo1> chapterInfo;

    public class ChapterInfo1 {
        public String chapter;
        public ArrayList<ChapterSection> section;
    }

    public class ChapterSection {
        public String content;
    }
}
