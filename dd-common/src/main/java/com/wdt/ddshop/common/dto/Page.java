package com.wdt.ddshop.common.dto;

/**
 *  封装分页请求的参数类
 */
public class Page {
    private int page;
    private int rows;
// private int offset;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getOffset() {
        return (page-1)*rows;
    }
}
