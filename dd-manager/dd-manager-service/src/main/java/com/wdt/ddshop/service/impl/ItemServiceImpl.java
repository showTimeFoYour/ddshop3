package com.wdt.ddshop.service.impl;

import com.wdt.ddshop.common.dto.Order;
import com.wdt.ddshop.common.dto.Page;
import com.wdt.ddshop.common.dto.Result;
import com.wdt.ddshop.dao.TbItemCustomMapper;
import com.wdt.ddshop.dao.TbItemMapper;
import com.wdt.ddshop.pojo.po.TbItem;
import com.wdt.ddshop.pojo.po.TbItemExample;
import com.wdt.ddshop.pojo.vo.TbItemCustom;
import com.wdt.ddshop.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    private TbItemMapper itemDao;
    @Autowired
    private TbItemCustomMapper itemCustomDao;

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
    public Result<TbItemCustom> listItemsByPage(Page page,Order order) {
        Result<TbItemCustom> result = null;
        try {
            result = new Result<>();
            int total=itemCustomDao.countItems();
            result.setTotal(total);
           List<TbItemCustom> rows =itemCustomDao.listItemCustomByPage(page,order);
            result.setRows(rows);
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int updateItemsById(List<Long> ids) {
        int i=0;
        try{
            TbItem record=new TbItem();
            record.setStatus( (byte)3);
//         创建更新模板
            TbItemExample  example=new TbItemExample();
            TbItemExample.Criteria criteria = example.createCriteria();
            criteria.andIdIn(ids);
            i=itemDao.updateByExampleSelective(record,example);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;

}
}
