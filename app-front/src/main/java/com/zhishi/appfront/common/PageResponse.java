package com.zhishi.appfront.common;

public class PageResponse extends EquityResult {


    public PageResponse(String msg, Object object, int state, int pageNum, int pageSize, int totalPageNum, boolean nextPage) {
        this.msg = msg;
        this.object = object;
        this.state = state;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalPageNum = totalPageNum;
        this.nextPage = nextPage;
    }

    private String msg;        //错误成功信息
    private Object object;//返回值
    private int state; // 0 成功  1 请先登陆 2 登陆失效  3 信息不规范   4 业务逻辑错误

    private int pageNum;

    private int pageSize = 10;

    private int totalPageNum;

    private boolean nextPage;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

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

    public int getTotalPageNum() {
        return totalPageNum;
    }

    public void setTotalPageNum(int totalPageNum) {
        this.totalPageNum = totalPageNum;
    }


    public boolean isNextPage() {
        return nextPage;
    }

    public void setNextPage(boolean nextPage) {
        this.nextPage = nextPage;
    }
}
