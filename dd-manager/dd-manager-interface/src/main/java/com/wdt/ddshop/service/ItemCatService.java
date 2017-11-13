package com.wdt.ddshop.service;

import com.wdt.ddshop.common.dto.TreeNode;

import java.util.List;

public interface ItemCatService {
    /**
     * 查找分类栏
     * @param parentId
     * @return
     */
    List<TreeNode> listItemCatByPid(Long parentId);
}
