package com.guchen.service;

import com.guchen.pojo.Note;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guchen.utils.Result;

/**
* @author Administrator
* @description 针对表【note(品茶笔记表)】的数据库操作Service
* @createDate 2026-03-17 21:36:27
*/
public interface NoteService extends IService<Note> {
    Result selectNoteI();
    Result noteUpdateInsert(Note note);
    Result noteDelete(Note note);
}
