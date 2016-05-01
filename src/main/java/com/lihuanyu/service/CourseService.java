package com.lihuanyu.service;

import com.lihuanyu.dao.CourseDao;
import com.lihuanyu.dao.HistoryDao;
import com.lihuanyu.dto.CourseList;
import com.lihuanyu.dto.MainCourseJson;
import com.lihuanyu.model.Course;
import com.lihuanyu.model.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by skyADMIN on 16/5/1.
 */
@Service
public class CourseService {

    @Autowired
    private HistoryDao historyDao;

    @Autowired
    private CourseDao courseDao;

    private Sort sortByCreateDateDesc() {
        return new Sort(Sort.Direction.DESC, "createDate");
    }

    public CourseList getCouseListByPage(int page) {
        CourseList courseList = new CourseList();
        courseList.listCourse = new ArrayList<>();
        Iterable<Course> courses = courseDao.findAll();
        int begin = (page - 1) * 7;
        int num = 0;
        for (Course course : courses) {
            if (num <= begin) {
                num++;
            } else {
                if (num >= page * 7) {
                    courseList.more = "/courselist?page=" + (page + 1);
                    break;
                }
                CourseList.ListCourse listCours = new CourseList().new ListCourse();
                listCours.courseId = course.getId();
                listCours.courseName = course.getCourse_name();
                listCours.num = course.getNum();
                listCours.pubdate = course.getCreate_date().toString();
                listCours.thumbnailUrl = course.getThumbnail();
                courseList.listCourse.add(listCours);
                num++;
            }
        }
        return courseList;
    }

    public MainCourseJson getMainCourse() {
        MainCourseJson mainCourseJson = new MainCourseJson();
        Iterable<Course> recommendCourses = courseDao.findByIsRecommend(true);
        mainCourseJson.topCourse = dealTopCourse(recommendCourses);

        Iterable<Course> courses = courseDao.findAll();
        mainCourseJson = dealMainCourse(mainCourseJson, courses);
        return mainCourseJson;
    }

    private MainCourseJson dealMainCourse(MainCourseJson mainCourseJson, Iterable<Course> courses) {
        ArrayList<MainCourseJson.ListCourse> listCourses = new ArrayList<>();
        int num = 0;
        for (Course course : courses) {
            if (num >= 7) {
                mainCourseJson.more = "/courselist?page=2";
                break;
            }
            MainCourseJson.ListCourse listCourse = new MainCourseJson().new ListCourse();
            listCourse.courseId = (int) course.getId();
            listCourse.courseName = course.getCourse_name();
            listCourse.num = course.getNum();
            listCourse.pubdate = course.getCreate_date().toString();
            listCourse.thumbnailUrl = course.getThumbnail();
            listCourses.add(listCourse);
            num++;
        }
        mainCourseJson.listCourse = listCourses;
        return mainCourseJson;
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
        Iterable<History> histories = historyDao.findByCustomUserId(uid, sortByCreateDateDesc());

    }

}
