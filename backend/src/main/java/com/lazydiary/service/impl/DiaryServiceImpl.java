package com.lazydiary.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lazydiary.entity.Diary;
import com.lazydiary.mapper.DiaryMapper;
import com.lazydiary.service.DiaryService;
import org.springframework.stereotype.Service;

@Service
public class DiaryServiceImpl extends ServiceImpl<DiaryMapper, Diary> implements DiaryService {
} 