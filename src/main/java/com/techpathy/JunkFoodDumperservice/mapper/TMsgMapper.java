package com.techpathy.JunkFoodDumperservice.mapper;

import com.techpathy.JunkFoodDumperservice.entity.TMsg;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TMsgMapper {
    public TMsg findById(Integer id);
}
