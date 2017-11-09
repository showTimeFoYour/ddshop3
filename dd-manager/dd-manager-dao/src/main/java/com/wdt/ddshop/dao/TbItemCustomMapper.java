package com.wdt.ddshop.dao;

import com.wdt.ddshop.common.dto.Order;
import com.wdt.ddshop.common.dto.Page;
import com.wdt.ddshop.pojo.vo.TbItemCustom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbItemCustomMapper {
    int countItems();

    List<TbItemCustom> listItemCustomByPage(@Param("page") Page page,@Param("order") Order order);
}
