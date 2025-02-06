package com.trackpoint.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trackpoint.Entity.Event;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface EventMapper extends BaseMapper<Event> {
    @Insert("INSERT INTO event (userId, browser, version, timestamp,type) VALUES (#{userId}, #{browser}, #{version}, #{timestamp},#{type})")
    @Options(useGeneratedKeys = true, keyProperty = "eventId") // 获取生成的主键
    void insertEvent(Event event);
}
