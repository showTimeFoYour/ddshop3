package com.wdt.ddshop.service;

import com.wdt.ddshop.common.dto.Order;
import com.wdt.ddshop.common.dto.Page;
import com.wdt.ddshop.common.dto.Result;
import com.wdt.ddshop.pojo.po.TbItemParam;
import com.wdt.ddshop.pojo.vo.TbItemParamCustom;

public interface ItemParamService {
    Result<TbItemParamCustom> listItemParamsByPage(Page page,Order order);

    int saveParamItem(Long cid,TbItemParam itemParam);

    TbItemParam getItemParamByCid(Long cid);
}
