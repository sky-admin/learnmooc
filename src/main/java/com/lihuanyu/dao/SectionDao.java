package com.lihuanyu.dao;

import com.lihuanyu.model.Section;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by skyADMIN on 16/4/28.
 */
public interface SectionDao extends CrudRepository<Section,Long> {
    public Iterable<Section> findByChapterId(long chapterid);
}
