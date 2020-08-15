package com.tiger.consumption.manager.common;

import java.io.Serializable;
import java.util.List;

/**
 * 分页查询结果
 *
 * @Auther: Zeng Hu
 * @Date: 2020/7/26 17:18
 * @Description:
 * @Version: 1.0
 **/
public class PageResult<T> implements Serializable {
    private static final long serialVersionUID = 1541831407472077968L;
    public static final int PAGE_SIZE = 15;
    private int total;
    private int pageSize;
    private int current;
    private List<T> result;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }
}
