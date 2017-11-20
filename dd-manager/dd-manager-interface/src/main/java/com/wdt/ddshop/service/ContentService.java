package com.wdt.ddshop.service;

import com.wdt.ddshop.pojo.po.TbContent;

import java.util.List;

public interface ContentService {
    List<TbContent> listContentByCid(Long id);
}
