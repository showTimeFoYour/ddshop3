package com.wdt.ddshop.service.impl;

import com.wdt.ddshop.common.dto.TreeNode;
import com.wdt.ddshop.dao.TbItemCatMapper;
import com.wdt.ddshop.pojo.po.TbItemCat;
import com.wdt.ddshop.pojo.po.TbItemCatExample;
import com.wdt.ddshop.service.ItemCatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemCatServiceImpl implements ItemCatService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TbItemCatMapper itemCatDao;

    @Override
    public List<TreeNode> listItemCatByPid(Long parentId) {
        List<TreeNode> list = null;
        try {
            TbItemCatExample example = new TbItemCatExample();
            TbItemCatExample.Criteria criteria = example.createCriteria();
            criteria.andParentIdEqualTo(parentId);
            List<TbItemCat> tbItemCats = itemCatDao.selectByExample(example);
            list = new ArrayList<TreeNode>();

            for (int i = 0; i < tbItemCats.size(); i++) {
                TreeNode node = new TreeNode();
                TbItemCat tbItemCat = tbItemCats.get(i);
                node.setId(tbItemCat.getId());
                node.setText(tbItemCat.getName());
                node.setState(tbItemCat.getIsParent() ? "closed" : "open");
                list.add(node);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return list;

    }
}
