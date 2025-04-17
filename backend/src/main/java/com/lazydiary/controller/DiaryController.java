package com.lazydiary.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lazydiary.entity.Diary;
import com.lazydiary.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api/diaries")
@RequiredArgsConstructor
@CrossOrigin(allowCredentials = "true")
public class DiaryController {
    private final DiaryService diaryService;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @PostMapping
    public ResponseEntity<Diary> createDiary(@RequestBody Diary diary) {
        diary.setCreatedAt(LocalDateTime.now().format(formatter));
        diary.setUpdatedAt(LocalDateTime.now().format(formatter));
        diaryService.save(diary);
        return ResponseEntity.ok(diary);
    }

    @GetMapping
    public ResponseEntity<Page<Diary>> getDiaries(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(diaryService.page(new Page<>(page, size)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Diary> getDiary(@PathVariable Long id) {
        Diary diary = diaryService.getById(id);
        return diary != null ? ResponseEntity.ok(diary) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Diary> updateDiary(@PathVariable Long id, @RequestBody Diary diary) {
        Diary existingDiary = diaryService.getById(id);
        if (existingDiary == null) {
            return ResponseEntity.notFound().build();
        }
        diary.setId(id);
        diary.setCreatedAt(existingDiary.getCreatedAt());
        diary.setUpdatedAt(LocalDateTime.now().format(formatter));
        diaryService.updateById(diary);
        return ResponseEntity.ok(diary);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDiary(@PathVariable Long id) {
        diaryService.removeById(id);
        return ResponseEntity.ok().build();
    }
} 