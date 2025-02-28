package com.trackpoint.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trackpoint.Controller.Entity.Button;

import org.springframework.stereotype.Service;

@Service
public interface ButtonService extends IService<Button> {
    int LookA();
    int LookB();
    int LookC();
    int SalesA();
    int SalesB();
    int SalesC();
}