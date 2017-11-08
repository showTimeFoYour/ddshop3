package com.wdt.ddshop.service;

import com.wdt.ddshop.common.dto.Page;
import com.wdt.ddshop.common.dto.Result;
import com.wdt.ddshop.pojo.po.TbItem;
import com.wdt.ddshop.pojo.vo.TbItemCustom;

import java.util.List;

public interface ItemService {
    TbItem getById(Long itemId);

    List<TbItem> listItems();

    Result<TbItemCustom> listItemsByPage(Page page);

    int updateItemsById(List<Long> ids);
}
