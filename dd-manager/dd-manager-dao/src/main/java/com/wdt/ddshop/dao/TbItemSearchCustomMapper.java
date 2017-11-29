package com.wdt.ddshop.dao;

import com.wdt.ddshop.pojo.vo.TbItemSearchCustom;

import java.util.List;

public interface TbItemSearchCustomMapper {
    /***
     * 查询所有商品
     * @return
     */
    List<TbItemSearchCustom> listSearchItem();

    /***
     * 查询指定商品
     * @param itemId
     * @return
     */
    TbItemSearchCustom getById(Long itemId);
}
