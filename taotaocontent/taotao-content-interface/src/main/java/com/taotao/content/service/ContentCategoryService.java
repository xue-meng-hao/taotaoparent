package com.taotao.content.service;

import com.taotao.common.pojo.EasyUITreeNode;

import java.util.List;

public interface ContentCategoryService {
    //通过节点的id，查询节点的子节点
    public List<EasyUITreeNode> getContentCategoryList(Long parentId);
}
