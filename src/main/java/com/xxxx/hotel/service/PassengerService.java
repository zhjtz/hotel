package com.xxxx.hotel.service;

import com.sun.org.apache.regexp.internal.RE;
import com.xxxx.hotel.base.BaseService;
import com.xxxx.hotel.dao.PassengerMapper;
import com.xxxx.hotel.utils.AssertUtil;
import com.xxxx.hotel.utils.RegexUtils;
import com.xxxx.hotel.vo.Passenger;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class PassengerService extends BaseService<Passenger,Integer> {
    @Resource
    private PassengerMapper passengerMapper;

    /** 添加旅客 */
    @Transactional(propagation = Propagation.REQUIRED)
    public void addPassenger(Passenger passenger) {
       /* 1.参数校验 */
        // 非空校验
        AssertUtil.isTrue(StringUtils.isBlank(passenger.getName()),"姓名不能为空!"); // 姓名
        AssertUtil.isTrue(passenger.getGenderid()==null,"姓别不能为空!"); // 姓别
        AssertUtil.isTrue(StringUtils.isBlank(passenger.getBirthdate()),"出生日期不能为空!"); // 出生日期
        AssertUtil.isTrue(passenger.getNationid()==null,"民族不能为空!"); // 民族
        AssertUtil.isTrue(StringUtils.isBlank(passenger.getLicenceissuingauthorty()),"发证机关不能为空!"); // 发证机关
        AssertUtil.isTrue(StringUtils.isBlank(passenger.getPapersvalidity()),"证件有效期不能为空!"); // 证件有效期
        AssertUtil.isTrue(StringUtils.isBlank(passenger.getContactphonenumber()),"联系电话不能为空!"); // 联系电话
        AssertUtil.isTrue(passenger.getPapersid()==null,"证件类型不能为空!"); // 证件类型
        AssertUtil.isTrue(StringUtils.isBlank(passenger.getPapersnumber()),"证件号码不能为空!"); // 证件号码

        // 校验姓名是否是中文字符
        AssertUtil.isTrue(RegexUtils.checkChinese(passenger.getName())!=true,"姓名必须是中文字符!");
        // 校验出生日期格式是否正确
        AssertUtil.isTrue(RegexUtils.checkBirthday(passenger.getBirthdate())!=true,"请检查出生日期格式!");
        // 校验发证机关是否是中文字符
        AssertUtil.isTrue(RegexUtils.checkChinese(passenger.getLicenceissuingauthorty())!=true,"发证机关必须是中文字符!");
        // 校验证件有效期是否正确
        String[] papersvalidity=passenger.getPapersvalidity().split("至");
        for (String s : papersvalidity) {
            AssertUtil.isTrue(RegexUtils.checkBirthday(s)!=true,"请检查证件有效期填写格式!");
        }
        // 校验联系电话是否正确
        AssertUtil.isTrue(RegexUtils.checkMobile(passenger.getContactphonenumber())!=true,"请输入正确的联系方式!");
        // 校验身份证号是否正确
        AssertUtil.isTrue(RegexUtils.checkIdCard(passenger.getPapersnumber())!=true,"请输入正确的身份证号码!");


        // 判断旅客是否存在
        Passenger temp=passengerMapper.selectByPapersnumber(passenger.getPapersnumber());
        AssertUtil.isTrue(temp!=null,"尊敬的"+passenger.getName()+":您好!欢迎您再次光临!");


        /* 2.添加旅客 */
        AssertUtil.isTrue(passengerMapper.insertSelective(passenger)!=1,"添加旅客信息失败!");

    }

    /** 更新旅客 */
    @Transactional(propagation = Propagation.REQUIRED)
    public void updatePassenger(Passenger passenger) {
        /* 1.参数校验 */
        // 非空
        AssertUtil.isTrue(StringUtils.isBlank(passenger.getContactphonenumber()),"联系电话不能为空!"); //联系电话

        // 校验联系电话是否正确
        AssertUtil.isTrue(RegexUtils.checkMobile(passenger.getContactphonenumber())!=true,"请输入正确的联系方式!");

        // 判断对象是否存在,非空
        Passenger temp=passengerMapper.selectByPapersnumber(passenger.getPapersnumber());
        AssertUtil.isTrue(temp==null,"待更新旅客不存在!");

        // 判断有无修改信息
        AssertUtil.isTrue(passenger.getContactphonenumber().equals(temp.getContactphonenumber())
                && passenger.getProfession().equals(temp.getProfession())
                && passenger.getPassengerlevelid().equals(temp.getPassengerlevelid())
                && passenger.getUnitsoraddress().equals(temp.getUnitsoraddress())
                && passenger.getThingreasonid().equals(temp.getThingreasonid())
                && passenger.getWherearefrom().equals(temp.getWherearefrom())
                && passenger.getWheretogo().equals(temp.getWheretogo())
                && passenger.getRemarks().equals(temp.getRemarks()),"您暂未修改信息!");


        /* 2.执行更新操作,返回受影响的行数 */
        AssertUtil.isTrue(passengerMapper.updateByPrimaryKeySelective(passenger)!=1,"更新旅客信息失败!");
    }

}
