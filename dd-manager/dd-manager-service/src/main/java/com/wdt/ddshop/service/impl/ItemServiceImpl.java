package com.wdt.ddshop.service.impl;

import com.wdt.ddshop.common.dto.Order;
import com.wdt.ddshop.common.dto.Page;
import com.wdt.ddshop.common.dto.Result;
import com.wdt.ddshop.common.util.IDUtils;
import com.wdt.ddshop.dao.TbItemCustomMapper;
import com.wdt.ddshop.dao.TbItemDescMapper;
import com.wdt.ddshop.dao.TbItemMapper;
import com.wdt.ddshop.dao.TbItemParamItemMapper;
import com.wdt.ddshop.pojo.po.TbItem;
import com.wdt.ddshop.pojo.po.TbItemDesc;
import com.wdt.ddshop.pojo.po.TbItemExample;
import com.wdt.ddshop.pojo.po.TbItemParamItem;
import com.wdt.ddshop.pojo.vo.TbItemCustom;
import com.wdt.ddshop.pojo.vo.TbItemQuery;
import com.wdt.ddshop.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: DHC
 * Date: 2017/11/6
 * Time: 9:48
 * Version:V1.0
 */
@Service
public class ItemServiceImpl implements ItemService {
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TbItemDescMapper itemDescDao;
    @Autowired
    private TbItemMapper itemDao;
    @Autowired
    private TbItemCustomMapper itemCustomDao;
    @Autowired
    private TbItemParamItemMapper itemParamItemDao;

    @Override
    public TbItem getById(Long itemId) {
        TbItem tbItem = itemDao.selectByPrimaryKey(itemId);
        return tbItem;
    }

    @Override
    public List<TbItem> listItems() {
        List<TbItem> list = null;
        try {
            list = itemDao.selectByExample(null);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Result<TbItemCustom> listItemsByPage(Page page,Order order,TbItemQuery query) {
        Result<TbItemCustom> result = null;
        Map<String,Object> map=new HashMap<>();
        map.put("page",page);
        map.put("order",order);
        map.put("query",query);

        try {
            result = new Result<>();
            int total=itemCustomDao.countItems(map);
            result.setTotal(total);
           List<TbItemCustom> rows =itemCustomDao.listItemCustomByPage(map);
            result.setRows(rows);
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int updateItemsById(List<Long> ids,String url) {
        int i=0;
        try{
            if(url.contains("bacth")){
                TbItem record=new TbItem();
                record.setStatus( (byte)3);
//         创建更新模板
                TbItemExample  example=new TbItemExample();
                TbItemExample.Criteria criteria = example.createCriteria();
                criteria.andIdIn(ids);
                i=itemDao.updateByExampleSelective(record,example);
            }else if(url.contains("up")){
                TbItem record=new TbItem();
                record.setStatus( (byte)1);
//         创建更新模板
                TbItemExample  example=new TbItemExample();
                TbItemExample.Criteria criteria = example.createCriteria();
                criteria.andIdIn(ids);
                i=itemDao.updateByExampleSelective(record,example);
            }else{
                TbItem record=new TbItem();
                record.setStatus( (byte)2);
//         创建更新模板
                TbItemExample  example=new TbItemExample();
                TbItemExample.Criteria criteria = example.createCriteria();
                criteria.andIdIn(ids);
                i=itemDao.updateByExampleSelective(record,example);
            }

        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;

}

    /**
     * 添加事务
     * @param tbItem
     * @param content
     * @return
     */
 @Transactional
    @Override
    public Long saveItem(TbItem tbItem, String content,String paramData) {
     Long itemId = null;
        try{
         itemId= IDUtils.getItemId();
            tbItem.setId(itemId);
            tbItem.setStatus((byte)2);
            tbItem.setCreated(new Date());
            tbItem.setUpdated(new Date());
           int i=itemDao.insert(tbItem);
            TbItemDesc desc=new TbItemDesc();
            desc.setCreated(new Date());
            desc.setUpdated(new Date());
            desc.setItemId(itemId);
            desc.setItemDesc(content);
            i+=itemDescDao.insert(desc);
            TbItemParamItem itemParamItem=new TbItemParamItem();
            itemParamItem.setCreated(new Date());
            itemParamItem.setUpdated(new Date());
            itemParamItem.setItemId(itemId);
            itemParamItem.setParamData(paramData);
            i+=itemParamItemDao.insert(itemParamItem);



        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return  itemId;
    }
}
