package com.wdt.ddshop.service;

import com.wdt.ddshop.pojo.vo.TbSearchItemResult;

public interface SearchService {
    boolean importAllItem();

    TbSearchItemResult search(String keyword, Integer page, int rows);
}
