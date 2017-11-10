package com.wdt.ddshop.service;

import com.wdt.ddshop.common.dto.TreeNode;

import java.util.List;

public interface ItemCatService {

    List<TreeNode> listItemCatByPid(Long parentId);
}
