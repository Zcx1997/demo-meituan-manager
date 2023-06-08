package com.pro.domain;

import java.util.List;

public class PageResult {
    private Long total;
    private Long page;
    private List<Food> equipments;

    public PageResult(Long total, Long page, List<Food> equipments) {
        this.total = total;
        this.page = page;
        this.equipments = equipments;
    }
}
