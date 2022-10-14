package com.xxxx.hotel;

import com.alibaba.fastjson.JSON;
import com.xxxx.hotel.base.ResultInfo;
import com.xxxx.hotel.exceptions.AuthException;
import com.xxxx.hotel.exceptions.ParamsException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class GlobalExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {




        /**
         * 定义全局异常用户捕捉页面或数据错误
         * 异常处理方法(要判断是页面异常还是数据异常):
         *      1.返回视图
         *      2.返回Json数据
         *
         *      如何判断方法的返回值?
         *          通过方法上是否是否声明了@ResponseBody注解
         *              如果没有声明,则表示是返回页面
         *              如果声明了该注解,则返回是Json数据
         */

        /** 设置默认异常处理(返回视图)  */
        ModelAndView mv=new ModelAndView("error");
        // 设置异常信息
        mv.addObject("code",500);
        mv.addObject("msg","系统异常,请重试!....");

        // 通过HandlerMethod判断方法上有无@ResponseBody注解
        if (handler instanceof HandlerMethod){
            // 类型转换
            HandlerMethod handlerMethod= (HandlerMethod) handler;
            // 获取方法上声明的@ResponseBody注解对象
            ResponseBody responseBody=handlerMethod.getMethodAnnotation(ResponseBody.class);
            // 判断ResponseBody 对象是否为空,如果对象返回为空,则表示该方法是返回视图,不为空则是返回Json数据
            if (responseBody == null){
                // 方法返回视图
                // 判断是否属于自定义异常
                if (ex instanceof ParamsException){ // 参数异常
                    ParamsException p= (ParamsException) ex;
                    mv.addObject("code",p.getCode());
                    mv.addObject("msg",p.getMsg());
                }else if (ex instanceof AuthException){ //未认证异常
                    AuthException a= (AuthException) ex;
                    mv.addObject("code",a.getCode());
                    mv.addObject("msg",a.getMsg());
                }
                return mv;
            }else{
                // 方法返回数据
                // 设置返回参数的默认处理
                ResultInfo resultInfo=new ResultInfo();
                resultInfo.setCode(500);
                resultInfo.setMsg("系统异常,请重试!...");

                // 判断是否属于自定义异常
                if (ex instanceof ParamsException){ // 参数异常
                    ParamsException p= (ParamsException) ex;
                    resultInfo.setCode(p.getCode());
                    resultInfo.setMsg(p.getMsg());
                }else  if (ex instanceof AuthException){ //未认证异常
                    AuthException a= (AuthException) ex;
                    resultInfo.setCode(a.getCode());
                    resultInfo.setMsg(a.getMsg());
                }

                // 设置响应类型及编码格式 (设置成Json格式的字符串)
                response.setContentType("application/json;charset=UTF-8");

                // 通过输出流写出信息到页面
                PrintWriter out=null;
                try {
                    // 得到输出流
                    out=response.getWriter();
                    // 将resultInfo对象转换成Json格式的字符串
                    String jsonStr= JSON.toJSONString(resultInfo);
                    // 通过输出流写出
                    out.write(jsonStr);
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    // 如果对象不为空,则关闭
                    if (out != null) out.close();
                }

                // 不需要返回视图,只需要将JSon数据通过输出流写出即可
                return null;

            }
        }

        return mv;
    }
}
