package com.lihuanyu.dao;

import com.lihuanyu.model.Note;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

/**
 * Created by Explorer on 2016/5/3.
 */
public interface NoteDao extends CrudRepository<Note, Long> {
    Iterable<Note> findByCustomUserId(long customUserId);

}
