package com.lihuanyu.controllers;

import com.lihuanyu.dao.CourseDao;
import com.lihuanyu.dao.HistoryDao;
import com.lihuanyu.dto.HistoryDate;
import com.lihuanyu.model.Course;
import com.lihuanyu.model.History;
import com.lihuanyu.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by Explorer on 2016/5/2.
 */
@RestController
public class HistoryController {
    @Autowired
    private CourseDao courseDao;
    @Autowired
    private HistoryDao historyDao;
    @Autowired
    private HistoryService historyService;

    @RequestMapping(value = "/submit_history", method = RequestMethod.GET)
    public String saveHistory(long userId, long courseId) {
        Course course = courseDao.findById(courseId);
        History history = new History(userId, courseId, course.getCourse_name(), new Date());
        historyDao.save(history);
        return "success";
    }

    @RequestMapping("/get_history")
    public HistoryDate getHistoryCourse(long userid) {
        return historyService.getHistoryList(userid);
    }

}
