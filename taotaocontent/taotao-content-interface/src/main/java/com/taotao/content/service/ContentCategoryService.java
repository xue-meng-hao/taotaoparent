package com.taotao.content.service;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.common.pojo.TaotaoResult;

import java.util.List;

public interface ContentCategoryService {
    //通过节点的id，查询节点的子节点
    public List<EasyUITreeNode> getContentCategoryList(Long parentId);

    //添加内容分类
    public TaotaoResult createTaotaoResault(Long parentId, String name);

    //根据id删除节点
    public boolean deleteTaotaoResault(Long parentId);
}
