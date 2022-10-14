package com.xxxx.hotel.controller;

import com.google.gson.Gson;
import com.xxxx.hotel.base.BaseController;
import com.xxxx.hotel.service.StayRegisterService;
import com.xxxx.hotel.vo.RoomSetPo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("StayRegister")
@Controller
public class StayRegisterColltroller extends BaseController {
    @Resource
    private StayRegisterService stayRegisterService;

    /** 进入旅客信息页面 */
    @RequestMapping("list")
    public ModelAndView list(){
        ModelAndView mv=null;
        List<RoomSetPo> list=stayRegisterService.selectAll();
        mv=new ModelAndView("StayRegister/room");
        mv.addObject("list",list);
        return mv;
    }

    @RequestMapping("guestRoomLevelSelectRoom")
    @ResponseBody
    public Object guestRoomLevelSelectRoom(Integer guestRoomLevelID){
        List<RoomSetPo> list=null;
        if (guestRoomLevelID==0) {
            list=stayRegisterService.selectAll();
        }else {
            list=stayRegisterService.levelSelectInformation(guestRoomLevelID);
        }
        return list;
    }
}
