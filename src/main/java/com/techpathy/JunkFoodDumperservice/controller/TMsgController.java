package com.techpathy.JunkFoodDumperservice.controller;

import com.techpathy.JunkFoodDumperservice.entity.TMsg;
import com.techpathy.JunkFoodDumperservice.service.TMsgService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/msg")
public class TMsgController {

    @Autowired
    private TMsgService tMsgService;

    @GetMapping("/getMsg")
    public TMsg getMsg(@Param("id") Integer id){
        TMsg tMsg = tMsgService.findById(id);
        return tMsg;
    }

}