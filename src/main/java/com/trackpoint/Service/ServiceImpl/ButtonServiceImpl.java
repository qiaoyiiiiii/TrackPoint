package com.trackpoint.Service.ServiceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trackpoint.Entity.Button;
import com.trackpoint.Mapper.ButtonMapper;
import com.trackpoint.Service.ButtonService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ButtonServiceImpl extends ServiceImpl<ButtonMapper, Button> implements ButtonService {
    @Resource
    private ButtonMapper buttonMapper;
}