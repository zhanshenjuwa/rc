package com.zhishi.appfront.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class InitMsg {

    public static String way;

    @Value(value = "${way}")
    public void setWay(String way) {
        InitMsg.way = way;
    }

    public static String wayUrl;

    @Value(value = "${wayUrl}")
    public void setWayUrl(String wayUrl) {
        InitMsg.wayUrl = wayUrl;
    }
}
