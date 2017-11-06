package com.wdt.ddshop.web;

import com.wdt.ddshop.pojo.po.TbItem;
import com.wdt.ddshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User: DHC
 * Date: 2017/11/6
 * Time: 9:42
 * Version:V1.0
 */
@Controller
@Scope("prototype")
public class ItemAction {

    @Autowired
    private ItemService itemService;

    @ResponseBody
    @RequestMapping(value = "/item/{itemId}", method = RequestMethod.GET)
    public TbItem getById(@PathVariable("itemId") Long itemId) {
        System.out.println(itemId+"");

        TbItem tbItem = itemService.getById(itemId);

        return tbItem;
    }

    @RequestMapping("/{page}")
    public String page(@PathVariable("page") String page) {

        return page;
    }
}
