package com.xxxx.hotel.service;

import com.xxxx.hotel.base.BaseService;
import com.xxxx.hotel.dao.StayRegisterMapper;
import com.xxxx.hotel.vo.RoomSetPo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StayRegisterService extends BaseService<RoomSetPo,Integer> {

    @Resource
    private StayRegisterMapper stayRegisterMapper;

    public List<RoomSetPo> selectAll() {
        return stayRegisterMapper.selectAll();
    }

    public List<RoomSetPo> levelSelectInformation(Integer guestRoomLevelID) {
        return stayRegisterMapper.levelSelectInformation(guestRoomLevelID);
    }
}
