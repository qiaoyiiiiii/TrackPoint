package com.trackpoint.Controller;

import jakarta.annotation.Resource;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

import com.trackpoint.Service.ButtonService;
import com.trackpoint.Service.EventService;

import java.util.Arrays;
import java.util.List;

@RestController
public class WebSocketController {
    @Resource
    private SimpMessagingTemplate messagingTemplate;
    @Resource
    private ButtonService buttonService;
    private EventService eventService;

    @MessageMapping("/menber")  // 路径与前端发送的消息路径匹配
    @SendTo("/topic/public")  // 广播到所有订阅了 /topic/public 的客户端
    public int menbercount() {
        return eventService.countUserIds();
    }

    @MessageMapping("/sales")  // 路径与前端发送的消息路径匹配
    @SendTo("/topic/public")  // 广播到所有订阅了 /topic/public 的客户端
    public List<Integer> sales() {  // 修改 List<int> 为 List<Integer>
        int a = buttonService.SalesA();
        int b = buttonService.SalesB();
        int c = buttonService.SalesC();
        List<Integer> list = Arrays.asList(a, b, c);  // 修改为 Arrays.asList(a, b, c)
        return list;
    }
}
