package com.trackpoint.Controller;

import com.trackpoint.Entity.Error;
import com.trackpoint.Entity.Event;
import com.trackpoint.Entity.Form;
import com.trackpoint.Entity.Page;
import com.trackpoint.Service.EventService;
import com.trackpoint.Service.ErrorService;
import com.trackpoint.Service.ButtonService;
import com.trackpoint.Service.FormService;
import com.trackpoint.Service.PageService;
import jakarta.annotation.Resource;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/track")
public class EventController {
    @Resource
    private EventService eventService;
    @Resource
    private ErrorService errorService;
    @Resource
    private ButtonService buttonService;
    @Resource
    private FormService formService;
    @Resource
    private PageService pageService;
    

    @PostMapping("/error")
    public int trackError(@RequestBody Error error) {
        error.setType(3);
        errorService.save(error);
        return 200;
    }

    @PostMapping("/form")
    public int trackForm(@RequestBody Form form) {
        form.setType(2);
        formService.save(form);
        return 200;
    }
    @PostMapping("/page")
    public int trackPage(@RequestBody Page page) {
        Integer userId = page.getUserId();
        String browser = page.getBrowser();
        String version=page.getVersion();
        String time=page.getTimestamp();
        Event event=new Event(userId,browser,version,time,1);
        eventService.save(event);
        Integer pageId=event.getEvent();
        System.out.println(pageId);
        String pagePath=page.getPagePath();
        String referrer=page.getReferrer();
        pageService.savePage(pageId,pagePath,referrer);
        return 200;
    }

}
