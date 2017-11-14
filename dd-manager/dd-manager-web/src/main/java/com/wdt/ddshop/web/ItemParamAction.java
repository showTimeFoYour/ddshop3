package com.wdt.ddshop.web;

import com.wdt.ddshop.common.dto.Order;
import com.wdt.ddshop.common.dto.Page;
import com.wdt.ddshop.common.dto.Result;
import com.wdt.ddshop.pojo.po.TbItemParam;
import com.wdt.ddshop.pojo.vo.TbItemParamCustom;
import com.wdt.ddshop.service.ItemParamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

@Scope("prototype")
public class ItemParamAction {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ItemParamService itemParamService;

    @ResponseBody
    @RequestMapping(value = "itemParam/query/{cid}", method = RequestMethod.GET)
    public TbItemParam getItemParamByCid(@PathVariable("cid") Long cid) {
        TbItemParam itemParam = null;
        try {
            itemParam=  itemParamService.getItemParamByCid(cid);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return itemParam;
    }


    /**
     * 添加商品规格列表
     *
     * @param cid
     * @param itemParam
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "item/param/save/{cid}", method = RequestMethod.POST)
    public int saveParam(@PathVariable("cid") Long cid, TbItemParam itemParam) {
        int i = 0;
        try {
            i = itemParamService.saveParamItem(cid, itemParam);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return i;
    }

    @ResponseBody
    @RequestMapping("/itemParams")
    public Result<TbItemParamCustom> listItemParamsByPage(Page page, Order order) {
        Result<TbItemParamCustom> result = null;
        try {
            result = itemParamService.listItemParamsByPage(page, order);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return result;
    }
}
