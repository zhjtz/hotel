package com.xxxx.hotel.dao;


import com.xxxx.hotel.base.BaseMapper;
import com.xxxx.hotel.vo.Receivetarget;

public interface ReceivetargetMapper extends BaseMapper<Receivetarget,Integer> {

    // 根据团队编号查询团队信息
    Receivetarget selectByTeamcode(String teamcode);

    // 删除团队信息(批量删除)
    int deleteBatchByIds(Integer[] ids);
}