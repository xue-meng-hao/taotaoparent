package com.taotao.common.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * datagrid展示商品的pojo
 */
public class EasyUIDataResult implements Serializable {
    private Integer totol;
    private List rows;

    public Integer getTotol() {
        return totol;
    }

    public void setTotol(Integer totol) {
        this.totol = totol;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
