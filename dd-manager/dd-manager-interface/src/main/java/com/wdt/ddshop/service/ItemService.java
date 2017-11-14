package com.wdt.ddshop.service;

import com.wdt.ddshop.common.dto.Order;
import com.wdt.ddshop.common.dto.Page;
import com.wdt.ddshop.common.dto.Result;
import com.wdt.ddshop.pojo.po.TbItem;
import com.wdt.ddshop.pojo.vo.TbItemCustom;
import com.wdt.ddshop.pojo.vo.TbItemQuery;

import java.util.List;

public interface ItemService {
    TbItem getById(Long itemId);

    List<TbItem> listItems();

    /**
     * 分页处理
     * @param page
     * @param order
     * @param query
     * @return
     */
    Result<TbItemCustom> listItemsByPage(Page page,Order order,TbItemQuery query);

    /**
     * 批量修改
     * @param ids
     * @return
     */
    int updateItemsById(List<Long> ids,String url);

    /**
     * 添加商品
     * @param tbItem
     * @param content
     * @return
     */
    int saveItem(TbItem tbItem, String content);
}
