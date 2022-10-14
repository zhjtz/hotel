package com.xxxx.hotel.dao;

import com.xxxx.hotel.base.BaseMapper;
import com.xxxx.hotel.vo.Passenger;
import com.xxxx.hotel.vo.PassengersComments;


public interface PassengersCommentsMapper extends BaseMapper<PassengersComments,Integer> {

    int deleteBatchByIds(Integer[] ids);

    // 根据Id查询旅客信息
    Passenger selectById(Integer passengerid);
}