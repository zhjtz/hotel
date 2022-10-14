package com.xxxx.hotel.dao;

import com.xxxx.hotel.base.BaseMapper;
import com.xxxx.hotel.vo.Passenger;


public interface PassengerMapper  extends BaseMapper<Passenger,Integer> {

    /* 通过身份证号查询旅客是否存在 */
    Passenger selectByPapersnumber(String papersnumber);
}