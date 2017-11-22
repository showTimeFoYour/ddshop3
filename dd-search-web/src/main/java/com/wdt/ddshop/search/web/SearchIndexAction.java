package com.wdt.ddshop.search.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class SearchIndexAction {

    @RequestMapping("/")
    public String searchIndex(){
        return "search";
    }
}
