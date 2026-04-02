package com.guchen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guchen.pojo.Note;
import com.guchen.service.NoteService;
import com.guchen.mapper.NoteMapper;
import com.guchen.utils.JwtHelper;
import com.guchen.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
* @author Administrator
* @description 针对表【note(品茶笔记表)】的数据库操作Service实现
* @createDate 2026-03-17 21:36:27
*/
@Service
public class NoteServiceImpl extends ServiceImpl<NoteMapper, Note>
    implements NoteService{

    @Autowired
    HttpServletRequest request;

    @Autowired
    JwtHelper jwtHelper;

    @Autowired
    NoteMapper noteMapper;

    @Override
    public Result selectNoteI() {
        Long userId = jwtHelper.getUserId(request.getHeader("token"));
        List<Note> notesList = noteMapper.selectList(new QueryWrapper<Note>().eq("user_id", userId));
        Result result = Result.ok("品茶笔记表查询成功！");
        result.put("notesList", notesList);
        return result;
    }

    @Override
    public Result noteUpdateInsert(Note note) {
        Long userId = jwtHelper.getUserId(request.getHeader("token"));
        note.setUpdatedAt(new Date());
        LambdaUpdateWrapper<Note> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(Note::getId, note.getId());
        Note note1 = noteMapper.selectOne(updateWrapper);
        if (note1 != null) {
            noteMapper.update(note, updateWrapper);
            return Result.ok("TeXa笔记更新成功！");
        }
        note.setUserId(userId);
        note.setCreatedAt(new Date());
        noteMapper.insert(note);
        return Result.ok("品茶笔记插入成功！");
    }

    @Override
    public Result noteDelete(Note note) {
        int n = noteMapper.deleteById(note.getId());
        if (n > 0) {
            return Result.ok("TeXa笔记删除成功！");
        }
        return Result.error("TeXa笔记删除失败！没有该条记录！");
    }
}




