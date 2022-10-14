package com.xxxx.hotel.controller;

import com.xxxx.hotel.base.BaseController;
import com.xxxx.hotel.base.ResultInfo;
import com.xxxx.hotel.query.CommentsQuery;
import com.xxxx.hotel.service.CommentsService;
import com.xxxx.hotel.vo.Passenger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RequestMapping("comment")
@Controller
public class CommentController extends BaseController {
    @Resource
    private CommentsService commentsService;


    /** 进入评论管理页面 */
    @RequestMapping("list")
    public String list(){
        return "comments/comments";
    }

    /** 打开添加/修改 旅客信息 */
    @RequestMapping("toDetailsPage")
    public String toDetailsPage(Integer passengerid, HttpServletRequest request){
        Passenger passenger=commentsService.selectById(passengerid);
        // 将saleChance 设置到request请求域中
        request.setAttribute("passenger",passenger);
        return "comments/passengerDetails";
    }

    /** 分页条件查询 */
    @RequestMapping("select")
    @ResponseBody
    public Map<String, Object> selectByName(CommentsQuery commentsQuery){
        return commentsService.queryByParamsForTable(commentsQuery);
    }

    /** 删除评论 */
    @PostMapping("delete")
    @ResponseBody
    public ResultInfo deleteReceivetarget(Integer[] ids){
        commentsService.deleteBatchByIds(ids);
        return success("删除成功!");
    }


}
