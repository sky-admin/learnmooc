package com.lihuanyu.service;

import com.lihuanyu.dao.CourseDao;
import com.lihuanyu.dao.NoteDao;
import com.lihuanyu.dto.NoteDetailDto;
import com.lihuanyu.dto.NoteListDto;
import com.lihuanyu.model.Course;
import com.lihuanyu.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Explorer on 2016/5/3.
 */
@Service
public class NoteService {

    @Autowired
    private NoteDao noteDao;

    public void saveNote(long userId, String noteContent, String courseName) {
        Note note = new Note(userId, noteContent, courseName, new Date());
        noteDao.save(note);
    }

    public NoteListDto getNoteList(long userId) {
        Iterable<Note> noteList = noteDao.findByCustomUserId(userId);
        NoteListDto noteListDto = new NoteListDto();

        ArrayList<NoteListDto.NoteInfo> noteInfos = new ArrayList<>();
        for (Note note : noteList) {
            NoteListDto.NoteInfo noteInfo = new NoteListDto().new NoteInfo();
            noteInfo.courseName = note.getCourseOrExptName();
            noteInfo.thumbnailUrl = "";
            noteInfos.add(noteInfo);
        }
        noteListDto.listCourse = noteInfos;
        return noteListDto;
    }

    public NoteDetailDto getNoteDetail(long userId, String courseName) {
        Iterable<Note> noteList = noteDao.findByCustomUserId(userId);
        NoteDetailDto noteDetailDto = new NoteDetailDto();
        ArrayList<NoteDetailDto.NoteDetailInfo> list = new ArrayList<>();
        for (Note note : noteList) {
            if (note.getCourseOrExptName().equals(courseName)) {
                NoteDetailDto.NoteDetailInfo noteDetailInfo = new NoteDetailDto().new NoteDetailInfo();
                noteDetailInfo.noteId = note.getId();
                noteDetailInfo.time = note.getCreateDate().toString();
                noteDetailInfo.content = note.getNoteContent();
                list.add(noteDetailInfo);
            }
        }
        noteDetailDto.noteDetail = list;
        return noteDetailDto;
    }

    public String removeNote(long noteId) {
        noteDao.delete(noteId);
        return "success";
    }

}
