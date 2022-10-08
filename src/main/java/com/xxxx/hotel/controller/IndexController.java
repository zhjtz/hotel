package com.xxxx.hotel.controller;

import com.xxxx.hotel.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController extends BaseController {


    /** 系统登录页面 */
    @RequestMapping("login")
    public String login(){
        return "login";
    }

    /** 系统主页面 */
    @RequestMapping("index")
    public String index(){
        return "index";
    }



}
