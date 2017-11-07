package com.wdt.ddshop.dao;

import com.wdt.ddshop.common.dto.Page;
import com.wdt.ddshop.pojo.vo.TbItemCustom;

import java.util.List;

public interface TbItemCustomMapper {
    int countItems();

    List<TbItemCustom> listItemCustomByPage(Page page);
}
