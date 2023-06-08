package com.pro.service;

import com.pro.domain.PageResult;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pro.domain.Food;

import java.util.List;

public interface FoodService extends IService<Food> {
    PageResult getAll(int currentPage);
    List<Food> getlist();
}
