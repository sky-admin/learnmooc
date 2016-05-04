package com.lihuanyu.controllers;

import com.lihuanyu.dto.ScoreDto;
import com.lihuanyu.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Explorer on 2016/5/3.
 */
@RestController
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    @RequestMapping(value = "/get_score", method = RequestMethod.GET)
    public ScoreDto getScore(long userId) {
        return scoreService.getScoreList(userId);
    }
}
