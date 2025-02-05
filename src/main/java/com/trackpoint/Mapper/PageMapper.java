package com.trackpoint.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trackpoint.Entity.Page;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PageMapper extends BaseMapper<Page> {
    @Insert("INSERT INTO page (page, pagePath, referrer) VALUE ({page},{pagePath},{referrer})")
    public void savePage(Integer page,String pagePath,String referrer);
}