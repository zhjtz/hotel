package com.xxxx.hotel.controller;

import com.xxxx.hotel.base.BaseController;
import com.xxxx.hotel.base.ResultInfo;
import com.xxxx.hotel.query.PassengerQuery;
import com.xxxx.hotel.service.PassengerService;
import com.xxxx.hotel.vo.Passenger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RequestMapping("passenger")
@Controller
public class PassengerController extends BaseController {
    @Resource
    private PassengerService passengerService;

    /** 进入旅客信息页面 */
    @RequestMapping("list")
    public String list(){
        return "passenger/person";
    }

    /** 打开添加/修改 旅客信息 */
    @RequestMapping("toAddUpdatePage")
    public String toAddUpdatePage(Integer id, HttpServletRequest request){
        // 通过id是否有值判断是否是更新操作
        if (id != null){
            // 通过id查询营销机会数据
            Passenger passenger=passengerService.selectByPrimaryKey(id);
            // 将saleChance 设置到request请求域中
            request.setAttribute("passenger",passenger);
        }
        return "passenger/add_update";
    }


    /** 分页条件查询 */
    @RequestMapping("select")
    @ResponseBody
    public Map<String, Object> selectByName(PassengerQuery passengerQuery){
        return passengerService.queryByParamsForTable(passengerQuery);
    }

    /** 添加旅客信息 */
    @PostMapping("add")
    @ResponseBody
    public ResultInfo addPassenger(Passenger passenger){
        // 调用service层添加的方法
        passengerService.addPassenger(passenger);
        return success("添加旅客成功!");
    }

    /** 更新旅客信息 */
    @PostMapping("update")
    @ResponseBody
    public ResultInfo updatePassenger(Passenger passenger){
        // 调用service层添加的方法
        passengerService.updatePassenger(passenger);
        return success("添加旅客成功!");
    }

    /** 删除旅客信息(批量删除) */
    @PostMapping("delete")
    @ResponseBody
    public ResultInfo deletePassenger(Integer[] ids){
        passengerService.deleteBatch(ids);
        return success("删除成功!");
    }





}
