package com.wdt.ddshop.common.dto;

import java.util.List;

public class Result<T> {

private int total;
    /**
     *指定页码集合
     */
    private List<T> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
