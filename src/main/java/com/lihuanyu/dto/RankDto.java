package com.lihuanyu.dto;

import java.util.ArrayList;

/**
 * Created by skyADMIN on 16/5/4.
 */
public class RankDto {

    public ArrayList<RankDataJson> rankData;

    public class RankDataJson{
        public String avatar;
        public long id;
        public String nickname;
        public int score;
    }
}
