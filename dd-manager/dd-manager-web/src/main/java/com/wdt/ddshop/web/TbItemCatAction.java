package com.wdt.ddshop.web;

import com.wdt.ddshop.common.dto.TreeNode;
import com.wdt.ddshop.service.ItemCatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Scope("prototype")
public class TbItemCatAction {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping("itemCatList")
    @ResponseBody
    public List<TreeNode> listItemCatByPid(@RequestParam("parentId") Long parentId) {
        List<TreeNode> list = null;
        try {
            list = itemCatService.listItemCatByPid(parentId);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return list;
    }
}
