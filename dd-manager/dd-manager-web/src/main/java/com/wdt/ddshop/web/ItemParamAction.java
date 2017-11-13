package com.wdt.ddshop.web;

import com.wdt.ddshop.common.dto.Order;
import com.wdt.ddshop.common.dto.Page;
import com.wdt.ddshop.common.dto.Result;
import com.wdt.ddshop.pojo.vo.TbItemParamCustom;
import com.wdt.ddshop.service.ItemParamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller

@Scope("prototype")
public class ItemParamAction {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ItemParamService itemParamService;


    @ResponseBody
    @RequestMapping("/itemParams")
    public Result<TbItemParamCustom> listItemParamsByPage(Page page, Order order){
        Result<TbItemParamCustom> result = null;
        try {
            result = itemParamService.listItemParamsByPage(page,order);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return result;
    }
}
