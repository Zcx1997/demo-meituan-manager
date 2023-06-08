package com.pro.controller;


import com.pro.domain.Food;
import com.pro.domain.PageResult;
import com.pro.mapper.FoodMapper;
import com.pro.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class FoodController {

    @Autowired
    private FoodService foodService;

    @Autowired
    private FoodMapper foodMapper;
    @PostMapping("/getAll")
    public List<Food> getList(){
        List<Food> getlist = foodService.getlist();
        return getlist;
    }
    @PostMapping("/save")
    public String save(String foodName,String subTitle,String cover,Integer categoryId,Integer num ){
        Food food = new Food(foodName,subTitle,cover,categoryId,num);
      foodMapper.insert(food);
      return "success";
    }

    @PostMapping("/update")
    public String update(long foodId,String foodName,String subTitle,String cover,Integer categoryId,Integer num ){
        Food food = new Food(foodName,subTitle,cover,categoryId,num);
        food.setFoodId(foodId);
        foodMapper.updateById(food);
        return "success";
    }
    @PostMapping("/delete")
    public String delete(long foodId ){
        foodMapper.deleteById(foodId);
        return "success";
    }

    @PostMapping("/selectById")
    public Food selectById(Long foodId){
        Food food = foodMapper.selectById(foodId);
        return food;
    }


}
