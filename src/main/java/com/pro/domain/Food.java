package com.pro.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@TableName("food")
public class Food {
    @TableId(type = IdType.AUTO)
    private Long foodId;
    private String foodName;
    private String subTitle;
    private String cover;
    private int categoryId;
    private float score;
    private int quantity;
    private int num;


    public Food(Long foodId, String foodName, String subTitle, String cover, int categoryId, float score, int quantity, int num) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.subTitle = subTitle;
        this.cover = cover;
        this.categoryId = categoryId;
        this.score = score;
        this.quantity = quantity;
        this.num = num;
    }

    public Food(String foodName, String subTitle, String cover, int categoryId, int num) {
        this.foodName = foodName;
        this.subTitle = subTitle;
        this.cover = cover;
        this.categoryId = categoryId;
        this.num = num;
    }
}
