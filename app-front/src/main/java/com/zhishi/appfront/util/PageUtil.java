package com.zhishi.appfront.util;

public class PageUtil {

    /**
     * 获取总页数
     *
     * @param count    数据总数
     * @param pageSize 页数大小
     * @return
     */
    public static int getPageCount(int count, int pageSize) {
        return (count % pageSize) == 0 ? count / pageSize : (count / pageSize) + 1;
    }


}
