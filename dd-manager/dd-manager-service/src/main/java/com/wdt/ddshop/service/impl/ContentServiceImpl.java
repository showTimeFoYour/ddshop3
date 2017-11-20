package com.wdt.ddshop.service.impl;

import com.wdt.ddshop.common.jedis.JedisClient;
import com.wdt.ddshop.common.util.JsonUtils;
import com.wdt.ddshop.dao.TbContentMapper;
import com.wdt.ddshop.pojo.po.TbContent;
import com.wdt.ddshop.pojo.po.TbContentExample;
import com.wdt.ddshop.service.ContentService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TbContentMapper tbContentDao;
    @Autowired
    private JedisClient jedisClient;

    /***
     * jedisClient  缓存
     * @param id
     * @return
     */
    @Override
    public List<TbContent> listContentByCid(Long id) {
        List<TbContent> list = null;
        try {
            String content_list = jedisClient.hget("CONTENT_LIST",id+"");
            if (StringUtils.isNotBlank(content_list)) {

                return JsonUtils.jsonToList(content_list, TbContent.class);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }

        TbContentExample example = new TbContentExample();
        TbContentExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(id);
        list = tbContentDao.selectByExample(example);


        try {
            jedisClient.hset("CONTENT_LIST", id + "", JsonUtils.objectToJson(list));

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return list;
    }
}
