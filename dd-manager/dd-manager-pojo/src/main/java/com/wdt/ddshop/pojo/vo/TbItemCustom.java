package com.wdt.ddshop.pojo.vo;

import com.wdt.ddshop.pojo.po.TbItem;

public class TbItemCustom extends TbItem {
    private String catName;
    private String priceView;

    public String getPriceView() {
        return priceView;
    }

    public void setPriceView(String priceView) {
        this.priceView = priceView;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }
}
