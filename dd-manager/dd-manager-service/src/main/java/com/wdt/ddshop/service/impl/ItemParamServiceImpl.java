package com.wdt.ddshop.service.impl;

import com.wdt.ddshop.common.dto.Order;
import com.wdt.ddshop.common.dto.Page;
import com.wdt.ddshop.common.dto.Result;
import com.wdt.ddshop.dao.TbItemParamCustomMapper;
import com.wdt.ddshop.pojo.vo.TbItemParamCustom;
import com.wdt.ddshop.service.ItemParamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ItemParamServiceImpl implements ItemParamService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TbItemParamCustomMapper itemParamCustomDao;

    @Override
    public Result<TbItemParamCustom> listItemParamsByPage(Page page,Order order) {
        Result<TbItemParamCustom> result = null;

        try {
            result= new Result<TbItemParamCustom>();
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("page",page);
            map.put("order",order);
           int count =itemParamCustomDao.countItemParams();
           result.setTotal(count);
          List<TbItemParamCustom>  list =itemParamCustomDao.listItemParamsByPage(map);
          result.setRows(list);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }


        return result;
    }
}
