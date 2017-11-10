package com.wdt.ddshop.dao;

import com.wdt.ddshop.common.dto.Order;
import com.wdt.ddshop.common.dto.Page;
import com.wdt.ddshop.pojo.vo.TbItemCustom;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TbItemCustomMapper {
    int countItems(Map<String,Object> map);

    List<TbItemCustom> listItemCustomByPage(Map<String,Object> map);
}
