package com.xxxx.hotel.dao;

import com.xxxx.hotel.base.BaseMapper;
import com.xxxx.hotel.vo.RoomSetPo;

import java.util.List;

public interface StayRegisterMapper extends BaseMapper<RoomSetPo,Integer> {
    List<RoomSetPo> selectAll();

    List<RoomSetPo> levelSelectInformation(Integer guestRoomLevelID);
}
