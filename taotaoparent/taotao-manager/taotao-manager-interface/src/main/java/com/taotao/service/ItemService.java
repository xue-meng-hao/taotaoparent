package com.taotao.service;

import com.taotao.common.pojo.EasyUIDataResult;

/**
 * 商品相关的接口
 */
public interface ItemService {
    /**
     * 根据当前页码和行数进行分页
     *
     * @param page
     * @param rows
     * @return
     */
    public EasyUIDataResult getItemResult(Integer page, Integer rows);
}
