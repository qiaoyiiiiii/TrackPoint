package com.trackpoint.Service.ServiceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trackpoint.Entity.Event;
import com.trackpoint.Mapper.EventMapper;
import com.trackpoint.Service.EventService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl extends ServiceImpl<EventMapper, Event> implements EventService {
    @Resource
    private EventMapper eventMapper;

}
