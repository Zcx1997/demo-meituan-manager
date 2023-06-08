package com.pro.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pro.domain.Food;
import com.pro.domain.PageResult;
import com.pro.mapper.FoodMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

@Service
public class FoodServiceImpl extends ServiceImpl<FoodMapper,Food> implements FoodService {

    @Resource
    private FoodMapper foodMapper;
    @Override
    public PageResult getAll(int currentPage) {
        QueryWrapper queryWrapper = new QueryWrapper();
        Page<Food> page = new Page<>(currentPage,10);
        IPage<Food> IPage = foodMapper.selectPage(page,queryWrapper);
        PageResult pageResult = new PageResult(IPage.getTotal(),IPage.getPages(),IPage.getRecords());
        return pageResult;
    }

    @Override
    public List<Food> getlist() {
        QueryWrapper queryWrapper = new QueryWrapper();
        List list = foodMapper.selectList(queryWrapper);
        return list;
    }
}
