package com.wdt.ddshop.web;

import com.wdt.ddshop.common.dto.MessageResult;
import com.wdt.ddshop.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SearchItemAction {

    @Autowired
    private SearchService searchService;
    @ResponseBody
@RequestMapping("item/search/import")
public MessageResult importItemList(){
 boolean boo=        searchService.importAllItem();
        MessageResult mr=new MessageResult();
if(boo){

    mr.setSuccess(true);
    mr.setMessage("索引导入成功");
}else {
    mr.setSuccess(false);
    mr.setMessage("索引导入失败");
}
    return mr;
}
}
