package com.lihuanyu.service;

import com.lihuanyu.dao.ChapterDao;
import com.lihuanyu.dao.SectionDao;
import com.lihuanyu.dto.ChapterInfo;
import com.lihuanyu.model.Chapter;
import com.lihuanyu.model.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by skyADMIN on 16/4/28.
 */
@Service
public class ChapterInfoService {

    @Autowired
    private ChapterDao chapterDao;

    @Autowired
    private SectionDao sectionDao;

    public ChapterInfo getChapterInfo(int courseid){
        long courseidlong = courseid;
        Iterable<Chapter> chapters = chapterDao.findByCourseId(courseidlong);
        ChapterInfo chapterInfo = new ChapterInfo();
        //遍历chapters,对每一个chpterid查它的section信息.
        for (Iterator<Chapter> it = chapters.iterator();it.hasNext();){
            Chapter chapter = it.next();
            long chapterid = chapter.getId();

            ChapterInfo.ChapterInfo1 chapterInfo1s = new ChapterInfo().new ChapterInfo1();

            chapterInfo1s.chapter = chapter.getChapterName();

            Iterable<Section> sections = sectionDao.findByChapterId(chapterid);
            //对每个chapter,查询Section,遍历selection,存进数组.
            ArrayList<ChapterInfo.ChapterSection> chapterSections = new ArrayList<ChapterInfo.ChapterSection>();
            for (Iterator<Section> its = sections.iterator();it.hasNext();){
                Section section = its.next();
                ChapterInfo.ChapterSection chapterSection = new ChapterInfo().new ChapterSection();
                chapterSection.content = section.getSectionContent();
                chapterSections.add(chapterSection);
            }
            chapterInfo1s.section = chapterSections;
            chapterInfo.chapterInfo.add(chapterInfo1s);
        }
        return chapterInfo;
    }
}
