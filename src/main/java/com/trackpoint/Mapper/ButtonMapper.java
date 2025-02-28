package com.trackpoint.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trackpoint.Controller.Entity.Button;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ButtonMapper extends BaseMapper<Button> {
    // 获取购买数量A
    @Select("SELECT COUNT(button) FROM button where button=1")
    int countGoodsA();
    // 获取购买数量B
    @Select("SELECT COUNT(button) FROM button where button=2")
    int countGoodsB();
    // 获取购买数量C
    @Select("SELECT COUNT(button) FROM button where button=3")
    int countGoodsC();
    // 获取购买数量A
    @Select("SELECT COUNT(button) FROM button where button=4")
    int countA();
    // 获取购买数量A
    @Select("SELECT COUNT(button) FROM button where button=5")
    int countB();
    // 获取购买数量A
    @Select("SELECT COUNT(button) FROM button where button=6")
    int countC();
} 