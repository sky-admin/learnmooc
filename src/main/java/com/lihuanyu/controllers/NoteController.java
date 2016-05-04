package com.lihuanyu.controllers;

import com.lihuanyu.dto.NoteDetailDto;
import com.lihuanyu.dto.NoteListDto;
import com.lihuanyu.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Explorer on 2016/5/3.
 */
@RestController
public class NoteController {

    @Autowired
    private NoteService noteService;

    @RequestMapping(value = "/save_note")
    public String saveNote(long userId, String noteContent, String courseName) {
        noteService.saveNote(userId, noteContent, courseName);
        return "success";
    }

    @RequestMapping(value = "/note_list", method = RequestMethod.GET)
    public NoteListDto getNoteList(long userId) {
        return noteService.getNoteList(userId);
    }

    @RequestMapping(value = "/note_detail_list", method = RequestMethod.GET)
    public NoteDetailDto getNoteDetailList(long userId, String courseName) {
        return noteService.getNoteDetail(userId, courseName);
    }

    @RequestMapping(value = "/remove_note", method = RequestMethod.GET)
    public String removeNote(long noteId) {
        return noteService.removeNote(noteId);
    }
}
