package com.trackpoint.Controller;

import com.trackpoint.Service.EventService;
import jakarta.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trackpoint.Entity.Event;

@RestController
@RequestMapping("/track")
public class EventController {
    @Resource
    private EventService eventService;

    @PostMapping
    public int trackPoint(@RequestBody Event event) {
        if(event.getEventName().equals("")){
            eventService.save(event);
            return 200;
    }
    return 400;
}
}
