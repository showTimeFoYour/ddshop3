package com.wdt.ddshop.web;

import com.wdt.ddshop.common.dto.MessageResult;
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
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.jms.*;
import javax.servlet.http.HttpServletRequest;
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
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private JmsTemplate jmsTemplate;
    @Resource
    private Destination topicDestination;
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
            logger.error(e.getMessage(), e);
        }
        return list;
    }

    /**
     * 分页处理
     * @param page
     * @param order
     * @param query
     * @return
     */
    @RequestMapping("/itemsByPage")
    @ResponseBody
    public Result<TbItemCustom> getItemsByPage(Page page, Order order, TbItemQuery query) {
        Result<TbItemCustom> result = null;
        try {
            result = itemService.listItemsByPage(page, order, query);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 批量修改
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value = {"items/bacth","items/up","items/down"}, method = RequestMethod.POST)
    public int getBacth(@RequestParam("ids[]") List<Long> ids, HttpServletRequest request) {

        int i = 0;
        try {
            String url= request.getRequestURI();

            i = itemService.updateItemsById(ids,url);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return i;


    }

    /**
     * 新增商品
     * @param tbItem
     * @param content
     * @return
     */
   /* @ResponseBody
    @RequestMapping("/item")
   public  int  save(TbItem tbItem,String content,String paramData){
        int i=0;
        try{
            i=itemService.saveItem(tbItem,content,paramData);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return  i;
    }*/
    @ResponseBody
    @RequestMapping("/item")
    public MessageResult saveItem(TbItem tbItem, String content, String paramData) {
        MessageResult mr = new MessageResult();
        try {
            //1 保存商品
            final Long itemId = itemService.saveItem(tbItem, content, paramData);
            //2 发送消息
            jmsTemplate.send(topicDestination, new MessageCreator() {
                @Override
                public Message createMessage(Session session) throws JMSException {
                    TextMessage textMessage = session.createTextMessage(itemId + "");
                    return textMessage;
                }
            });
            mr.setSuccess(true);
            mr.setMessage("新增1个商品成功");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return mr;
    }

}
