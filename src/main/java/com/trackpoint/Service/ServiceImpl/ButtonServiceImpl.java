package com.trackpoint.Service.ServiceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trackpoint.Controller.Entity.Button;
import com.trackpoint.Mapper.ButtonMapper;
import com.trackpoint.Service.ButtonService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ButtonServiceImpl extends ServiceImpl<ButtonMapper, Button> implements ButtonService {
    @Resource
    private ButtonMapper buttonMapper;

    public int LookA(){
        return buttonMapper.countA();
    }
    public int LookB(){
        return buttonMapper.countB();
    }
    public int LookC(){
        return buttonMapper.countC();
    }
    public int SalesA(){
        return buttonMapper.countGoodsA();
    }
    public int SalesB(){
        return buttonMapper.countGoodsB();
    }
    public int SalesC(){
        return buttonMapper.countGoodsC();
    }
}