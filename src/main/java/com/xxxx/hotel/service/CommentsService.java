package com.xxxx.hotel.service;

import com.xxxx.hotel.base.BaseService;
import com.xxxx.hotel.dao.PassengersCommentsMapper;
import com.xxxx.hotel.utils.AssertUtil;
import com.xxxx.hotel.vo.Passenger;
import com.xxxx.hotel.vo.PassengersComments;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class CommentsService extends BaseService<PassengersComments,Integer> {
    @Resource
    private PassengersCommentsMapper passengersCommentsMapper;

    /** 删除旅客 */
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteBatchByIds(Integer[] ids) {
        // 判断id是否存在
        AssertUtil.isTrue(ids==null||ids.length<1,"待屏蔽记录不存在!");
        // 执行删除 (更新) 操作,判断受影响的行数
        AssertUtil.isTrue(passengersCommentsMapper.deleteBatchByIds(ids)!=ids.length,"评论信息屏蔽失败!");
    }

    /** 查询旅客 */
    public Passenger selectById(Integer passengerid) {
        // 判断id是否存在
        AssertUtil.isTrue(passengerid==null,"待屏蔽记录不存在!");
        // 执行删除 (更新) 操作,判断受影响的行数
        return  passengersCommentsMapper.selectById(passengerid);
    }
}
