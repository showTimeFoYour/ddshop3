package com.wdt.ddshop.web;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: DHC
 * Date: 2017/11/6
 * Time: 10:19
 * Version:V1.0
 */
@Controller
@Scope("prototype")
public class IndexAction {

    @RequestMapping("/")
    public String  index(){
        return "index";
    }

    @RequestMapping("/{page}")
    public String page(@PathVariable("page") String page) {

        return page;
    }

}
