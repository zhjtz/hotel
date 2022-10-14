package com.xxxx.hotel.controller;

import com.xxxx.hotel.base.BaseController;
import com.xxxx.hotel.base.ResultInfo;
import com.xxxx.hotel.query.PassengerQuery;
import com.xxxx.hotel.query.ReceivetargetQuery;
import com.xxxx.hotel.service.ReceivetargetService;
import com.xxxx.hotel.vo.Passenger;
import com.xxxx.hotel.vo.Receivetarget;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RequestMapping("receivetarget")
@Controller
public class ReceivetargetController extends BaseController {
    @Resource
    private ReceivetargetService receivetargetService;

    @RequestMapping("list")
    public String list(){
        return "team/team";
    }

    /** 分页条件查询 */
    @RequestMapping("select")
    @ResponseBody
    public Map<String, Object> selectByName(ReceivetargetQuery receivetargetQuery){
        return receivetargetService.queryByParamsForTable(receivetargetQuery);
    }

    /** 打开添加/修改 团队信息 */
    @RequestMapping("toAddUpdatePage")
    public String toAddUpdatePage(Integer id, HttpServletRequest request){
        // 通过id是否有值判断是否是更新操作
        if (id != null){
            // 通过id查询营销机会数据
            Receivetarget receivetarget=receivetargetService.selectByPrimaryKey(id);
            // 将saleChance 设置到request请求域中
            request.setAttribute("receivetarget",receivetarget);
        }
        return "team/add_update";
    }

    /** 添加团队信息 */
    @PostMapping("add")
    @ResponseBody
    public ResultInfo addReceivetarget(Receivetarget receivetarget){
        // 调用service层添加的方法
        receivetargetService.addReceivetarget(receivetarget);
        return success("添加团队成功!");
    }

    /** 删除团队信息(批量删除) */
    @PostMapping("delete")
    @ResponseBody
    public ResultInfo deleteReceivetarget(Integer[] ids){
        receivetargetService.deleteBatchByIds(ids);
        return success("删除成功!");
    }

    /** 更新团队信息 */
    @PostMapping("update")
    @ResponseBody
    public ResultInfo updatePassenger(Receivetarget receivetarget){
        // 调用service层添加的方法
        receivetargetService.updateReceivetarget(receivetarget);
        return success("添加旅客成功!");
    }
}
