package com.zhishi.appfront.common;


public class PageRequest {

    /**
     * 页数
     */
    private int pageNum;
    /**
     * 条数
     */
    private int pageSize;


    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
