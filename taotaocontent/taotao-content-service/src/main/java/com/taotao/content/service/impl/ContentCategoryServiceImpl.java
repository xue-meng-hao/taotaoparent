package com.taotao.content.service.impl;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.content.service.ContentCategoryService;
import com.taotao.mapper.TbContentCategoryMapper;
import com.taotao.pojo.TbContentCategory;
import com.taotao.pojo.TbContentCategoryExample;
import com.taotao.pojo.TbItemExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现内容分类
 */
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {
    @Autowired
    private TbContentCategoryMapper mapper;

    @Override
    public List<EasyUITreeNode> getContentCategoryList(Long parentId) {
        /** 1.注入mapper
         * 2.创建example
         *3.设置条件
         * 4.执行查询
         * 5.转为easyUITreeNode列表
         */
        TbContentCategoryExample example = new TbContentCategoryExample();
        TbContentCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<TbContentCategory> categories = mapper.selectByExample(example);
        List<EasyUITreeNode> nodes = new ArrayList<>();

        for (TbContentCategory category : categories) {
            EasyUITreeNode node = new EasyUITreeNode();
            node.setId(category.getId());
            node.setState(category.getIsParent() ? "closed" : "open");
            node.setText(category.getName());
            nodes.add(node);
        }
        return nodes;
    }
}
