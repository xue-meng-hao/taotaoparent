package com.taotao.content.service.impl;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.content.service.ContentCategoryService;
import com.taotao.mapper.TbContentCategoryMapper;
import com.taotao.pojo.TbContentCategory;
import com.taotao.pojo.TbContentCategoryExample;
import com.taotao.pojo.TbItemExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
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

    @Override
    public TaotaoResult createTaotaoResault(Long parentId, String name) {
        //1.创建对象 补全属性
        //2.插入表种的数据
        //3.返回包含的内容id       需要逐渐返回
        TbContentCategory tbContentCategory = new TbContentCategory();
        tbContentCategory.setCreated(new Date());
        tbContentCategory.setParentId(parentId);
        //获取父结点
        TbContentCategory parentCategory = mapper.selectByPrimaryKey(parentId);
        if (!parentCategory.getIsParent()) {
            parentCategory.setIsParent(true);
            mapper.updateByPrimaryKey(parentCategory);
        }
        tbContentCategory.setIsParent(false);
        tbContentCategory.setName(name);
        tbContentCategory.setSortOrder(1);
        tbContentCategory.setStatus(1);
        tbContentCategory.setUpdated(tbContentCategory.getCreated());

        mapper.insert(tbContentCategory);

        return TaotaoResult.ok();
    }

    @Override
    public boolean deleteTaotaoResault(Long id) {
        TbContentCategory tbContentCategory = mapper.selectByPrimaryKey(id);
        if (!tbContentCategory.getIsParent()) {
            int i = mapper.deleteByPrimaryKey(id);
            if (i > 0) {
                return true;
            }
        }
        return false;
    }

}
