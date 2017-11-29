package com.wdt.ddshop.search.web;

import com.wdt.ddshop.common.util.PropKit;
import com.wdt.ddshop.pojo.vo.TbSearchItemResult;
import com.wdt.ddshop.service.SearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;


@Controller
public class SearchIndexAction {
private Logger  logger =LoggerFactory.getLogger(this.getClass());

@Autowired
private SearchService searchService;
    @RequestMapping("/")
    public String searchIndex(String keyword, @RequestParam(defaultValue = "1")Integer page, Model model){
    try {
        if(keyword!=null) {


            keyword = new String(keyword.getBytes("iso-8859-1"), "utf-8");
        }  } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            String name = "page.properties";
            int rows = Integer.parseInt(PropKit.use(name).get("pageSize"));
            TbSearchItemResult searchResult = searchService.search(keyword, page, rows);
            model.addAttribute("query",keyword);
            model.addAttribute("totalPages",searchResult.getTotalPages());
            model.addAttribute("page",page);
            model.addAttribute("recordCount",searchResult.getRecordCount());
            model.addAttribute("itemList",searchResult.getItemList());

        return "search";
    }
}
