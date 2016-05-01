package com.lihuanyu.service;

import com.lihuanyu.dao.CourseDao;
import com.lihuanyu.dao.HistoryDao;
import com.lihuanyu.dto.MainCourseJson;
import com.lihuanyu.model.Course;
import com.lihuanyu.model.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by skyADMIN on 16/5/1.
 */
@Service
public class CourseService {

    @Autowired
    private HistoryDao historyDao;

    @Autowired
    private CourseDao courseDao;

    private Sort sortByIdDesc() {
        return new Sort(Sort.Direction.DESC, "createDate");
    }

    public void getMainCourse() {
        MainCourseJson mainCourseJson = new MainCourseJson();
        Iterable<Course> recommendCourses = courseDao.findByIsRecommend(true);
        mainCourseJson.topCourse = dealTopCourse(recommendCourses);

        Iterable<Course> courses = courseDao.findAll();

    }


    private void dealMainCourse(MainCourseJson mainCourseJson, Iterable<Course> courses) {
        ArrayList<MainCourseJson.ListCourse> listCourses = new ArrayList<>();
        int num = 0;
        for(Course course : courses){
            if (num >= 7){
                break;
            }

        }
    }

    /**
     * 处理topcourse,拿到所有推荐的课程,遍历处理到MainCourseJson类的topcourse属性里.
     *
     * @param recommendCourses
     * @return
     */
    private ArrayList<MainCourseJson.TopCourse> dealTopCourse(Iterable<Course> recommendCourses) {
        ArrayList<MainCourseJson.TopCourse> topCourses = new ArrayList<>();
        for (Course temp : recommendCourses) {
            MainCourseJson.TopCourse topCourse = new MainCourseJson().new TopCourse();
            topCourse.courseId = (int) temp.getId();
            topCourse.pubdate = temp.getCreate_date().toString();
            topCourse.topCourseImgUrl = temp.getThumbnail();
            topCourses.add(topCourse);
        }
        return topCourses;
    }

    public void getHistoryCourse(long uid) {
        Iterable<History> histories = historyDao.findByCustomUserId(uid, sortByIdDesc());

    }

}
