package com.trackpoint.Service.ServiceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trackpoint.Controller.Entity.Page;
import com.trackpoint.Mapper.PageMapper;
import com.trackpoint.Service.PageService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class PageServiceImpl extends ServiceImpl<PageMapper, Page> implements PageService {
    @Resource
    private PageMapper pageMapper;
}