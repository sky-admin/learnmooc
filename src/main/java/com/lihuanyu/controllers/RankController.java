package com.lihuanyu.controllers;

import com.lihuanyu.dto.RankDto;
import com.lihuanyu.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by skyADMIN on 16/5/4.
 */
@RestController
public class RankController {

    @Autowired
    private RankService rankService;

    @RequestMapping("/rank")
    public RankDto showRankList(){
        return rankService.getRankList();
    }
}
