package com.trackpoint.Controller;

import com.trackpoint.Entity.Button;
import com.trackpoint.Entity.Error;
import com.trackpoint.Entity.Event;
import com.trackpoint.Entity.Form;
import com.trackpoint.Entity.Page;
import com.trackpoint.Service.EventService;
import com.trackpoint.Service.ErrorService;
import com.trackpoint.Service.ButtonService;
import com.trackpoint.Service.FormService;
import com.trackpoint.Service.PageService;
import com.trackpoint.Utils.QueryParam;
import jakarta.annotation.Resource;

import java.util.HashMap;

import javax.print.DocFlavor.STRING;

import org.springframework.web.bind.annotation.*;

@RestController
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
    

    @PostMapping("/track")
    public int trackPage(@RequestBody QueryParam queryParam) {
        HashMap param = queryParam.getParam();
        String browser=(String)param.get("browser");
        Integer userId=(Integer)param.get("userId");
        String time=(String)param.get("timestamp");
        String version=(String)param.get("version");
        Event e=new Event(userId,browser,version,time);
        Integer eventId=0;
        switch (queryParam.getEventName()) {
            case "page":e.setType(1);
            String pagePath=(String)param.get("pagePath");
            String referrer=(String)param.get("referrer");
            eventService.saveEvent(e); // 保存 Event
            eventId = e.getEventId(); // 获取生成的 eventId
            Page p=new Page();
            p.setPage(eventId);// 传递 eventId
            p.setReferrer(referrer);
            p.setPagePath(pagePath);
            pageService.save(p); // 保存page
            return 200;
            case "error":e.setType(3);
            Error error=new Error();
            eventService.saveEvent(e); // 保存 Event
            error.setErrorId(e.getEventId()); // 传递 eventId
            error.setErrorMessage((String)param.get("errorMessage")); // 设置错误信息
            errorService.save(error); // 保存错误信息
            return 200;
            case "form":e.setType(2);
            eventService.saveEvent(e); // 保存 Event
            Form form=new Form();
            form.setFormId(e.getEventId()); // 传递 eventId
            form.setForm((String)param.get("formData")); // 设置表单数据
            formService.save(form); // 保存表单信息
            return 200;
            case "button":e.setType(0);
            eventService.saveEvent(e); // 保存 Event
            Button button=new Button();
            button.setButtonId(e.getEventId()); // 传递 eventId
            button.setButton((String)param.get("button"));
            button.setPositionX((Integer)param.get("positionX"));
            button.setPositionY((Integer)param.get("positionY"));
            buttonService.save(button); // 保存按钮信息
            return 200;
            default:return 400;
        }

    }

}
