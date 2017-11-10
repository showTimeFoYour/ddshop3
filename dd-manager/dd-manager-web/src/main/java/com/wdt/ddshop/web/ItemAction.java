package com.wdt.ddshop.web;

import com.wdt.ddshop.common.dto.Order;
import com.wdt.ddshop.common.dto.Page;
import com.wdt.ddshop.common.dto.Result;
import com.wdt.ddshop.pojo.po.TbItem;
import com.wdt.ddshop.pojo.vo.TbItemCustom;
import com.wdt.ddshop.pojo.vo.TbItemQuery;
import com.wdt.ddshop.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * User: DHC
 * Date: 2017/11/6
 * Time: 9:42
 * Version:V1.0
 */
@Controller
@Scope("prototype")
public class ItemAction {
   private Logger logger=LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ItemService itemService;

    @ResponseBody
    @RequestMapping(value = "/item/{itemId}", method = RequestMethod.GET)
    public TbItem getById(@PathVariable("itemId") Long itemId) {
        System.out.println(itemId + "");

        TbItem tbItem = itemService.getById(itemId);

        return tbItem;
    }

    @RequestMapping("/items")
    @ResponseBody
    public List<TbItem> getTbitems() {
        List<TbItem> list = null;
        try {
            list = itemService.listItems();
        } catch (Exception e) {
logger.error(e.getMessage(),e);
        }
        return list;
    }
    @RequestMapping("/itemsByPage")
    @ResponseBody
    public Result<TbItemCustom> getItemsByPage(Page page, Order order,TbItemQuery query){
        Result<TbItemCustom> result=null;
        try {
            result = itemService.listItemsByPage(page,order,query);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return result;
    }
    @ResponseBody
    @RequestMapping(value = "items/bacth",method = RequestMethod.POST)
    public  int getBacth(@RequestParam("ids[]")List<Long>ids){
int i=0;
try{
    i=itemService.updateItemsById(ids);

}catch (Exception e){
logger.error(e.getMessage(),e);
e.printStackTrace();
}
        return i;


    }


}
