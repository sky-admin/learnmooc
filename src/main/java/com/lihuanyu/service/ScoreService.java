package com.lihuanyu.service;

import com.lihuanyu.dao.CourseDao;
import com.lihuanyu.dao.ScoreDao;
import com.lihuanyu.dto.ScoreDto;
import com.lihuanyu.model.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by Explorer on 2016/5/3.
 */
@Service
public class ScoreService {
    @Autowired
    private ScoreDao scoreDao;
    @Autowired
    private CourseDao courseDao;

    public ScoreDto getScoreList(long userId) {
        Iterable<Score> scoreIterable = scoreDao.findByCustomUserId(userId);
        ScoreDto scoreDto = new ScoreDto();
        ArrayList<ScoreDto.scoreInfo> scoreList = new ArrayList<>();
        for ( Score score:scoreIterable) {
            ScoreDto.scoreInfo scoreData = new ScoreDto().new scoreInfo();
            scoreData.courseName = courseDao.findById(score.getCourseOrExptId()).getCourse_name();
            scoreData.scores = score.getScores();
            scoreList.add(scoreData);
        }
        scoreDto.scoreList = scoreList;

        return scoreDto;
    }

}
