package com.techpathy.JunkFoodDumperservice.service.impl;

import com.techpathy.JunkFoodDumperservice.entity.TMsg;
import com.techpathy.JunkFoodDumperservice.mapper.TMsgMapper;
import com.techpathy.JunkFoodDumperservice.service.TMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TMsgServiceImpl implements TMsgService {

    @Autowired
    private TMsgMapper tMsgMapper;

    @Override
    public TMsg findById(Integer id) {
        return tMsgMapper.findById(id);
    }
}