package com.wdt.ddshop.common.dto;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String sort;
    private String order;


    public List<String> getOrderParams() {
        List<String> list = new ArrayList<String>();

        String[] sorts = this.sort.split(",");
        String[] orders = this.order.split(",");
        for (int i = 0; i < sorts.length; i++) {
            String temp = sorts[i] + " " + orders[i];
            list.add(temp);
        }
        return list;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;

    }


}
