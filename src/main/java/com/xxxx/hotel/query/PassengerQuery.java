package com.xxxx.hotel.query;

import com.xxxx.hotel.base.BaseQuery;

/** 旅客信息管理的查询类 */
public class PassengerQuery extends BaseQuery{
    private String name; // 根据姓名模糊查询

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
