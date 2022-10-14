package com.xxxx.hotel.service;

import com.xxxx.hotel.base.BaseService;
import com.xxxx.hotel.dao.ReceivetargetMapper;
import com.xxxx.hotel.utils.AssertUtil;
import com.xxxx.hotel.utils.RegexUtils;
import com.xxxx.hotel.vo.Receivetarget;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class ReceivetargetService extends BaseService<Receivetarget,Integer> {
    @Resource
    private ReceivetargetMapper receivetargetMapper;

    /** 添加团队信息 */
    @Transactional(propagation = Propagation.REQUIRED)
    public void addReceivetarget(Receivetarget receivetarget) {
        /* 1.参数校验 */
        // 判断非空
        AssertUtil.isTrue(receivetarget.getTargettypeid()==null,"请选择对象类别!");
        AssertUtil.isTrue(StringUtils.isBlank(receivetarget.getPrincipal()),"请填写负责人!");
        AssertUtil.isTrue(StringUtils.isBlank(receivetarget.getTeamname()),"请填写团队名称!");
        AssertUtil.isTrue(StringUtils.isBlank(receivetarget.getTeamcode()),"请填写团队编号!");
        AssertUtil.isTrue(StringUtils.isBlank(receivetarget.getContactphonenumber()),"请填写联系电话!");

        // 判断负责人是否是中文字符
        AssertUtil.isTrue(RegexUtils.checkChinese(receivetarget.getPrincipal())!=true,"请正确输入负责人的姓名!不允许出现非中文字符!");
        // 判断团队名称是否是中文字符
        AssertUtil.isTrue(RegexUtils.checkChinese(receivetarget.getTeamname())!=true,"请正确输入团队名称!不允许出现非中文字符!");
        // 判断团队编号是非中文字符
        AssertUtil.isTrue(RegexUtils.checkChinese(receivetarget.getTeamcode())!=false,"请正确输入团队编号!不允许出现中文字符!");
        // 判断联系电话格式是否合法
        AssertUtil.isTrue(RegexUtils.checkMobile(receivetarget.getContactphonenumber())!=true,"请输入正确的手机号码!");

        // 判断此团队是否存在
        Receivetarget temp=receivetargetMapper.selectByTeamcode(receivetarget.getTeamcode());
        AssertUtil.isTrue(temp!=null, "欢迎"+receivetarget.getTeamname()+"团队再次光临!");

        /* 2.设置默认值 */
        receivetarget.setRegistertime(new Date()); //设置登记时间

        /* 2.调用添加方法,返回受影响的行数 */
        AssertUtil.isTrue(receivetargetMapper.insertSelective(receivetarget)!=1,"添加团队信息失败!");
    }

    /** 删除团队信息(批量删除) */
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteBatchByIds(Integer[] ids) {
        // 判断id是否存在
        AssertUtil.isTrue(ids==null||ids.length<1,"待删除记录不存在!");
        // 执行删除 (更新) 操作,判断受影响的行数
        AssertUtil.isTrue(receivetargetMapper.deleteBatchByIds(ids)!=ids.length,"团队信息删除失败!");
    }

    /** 更新团队信息 */
    public void updateReceivetarget(Receivetarget receivetarget) {
        /* 1.参数校验 */
        // 非空
        AssertUtil.isTrue(StringUtils.isBlank(receivetarget.getPrincipal()),"负责人不能为空!");
        AssertUtil.isTrue(StringUtils.isBlank(receivetarget.getTeamname()),"团队名称不能为空!");
        AssertUtil.isTrue(StringUtils.isBlank(receivetarget.getContactphonenumber()),"联系电话不能为空!");

        // 判断负责人是否是中文字符
        AssertUtil.isTrue(RegexUtils.checkChinese(receivetarget.getPrincipal())!=true,"请正确输入负责人的姓名!不允许出现非中文字符!");
        // 判断团队名称是否是中文字符
        AssertUtil.isTrue(RegexUtils.checkChinese(receivetarget.getTeamname())!=true,"请正确输入团队名称!不允许出现非中文字符!");
        // 判断联系电话格式是否合法
        AssertUtil.isTrue(RegexUtils.checkMobile(receivetarget.getContactphonenumber())!=true,"请输入正确的手机号码!");

        // 判断是否是当前团队,不是则无权修改
        Receivetarget temp= receivetargetMapper.selectByTeamcode(receivetarget.getTeamcode());
        AssertUtil.isTrue(!receivetarget.getTeamcode().equals(temp.getTeamcode()),"您无权修改此信息!");

        // 判断有无修改信息
       AssertUtil.isTrue(receivetarget.getPrincipal().equals(temp.getPrincipal()) &&
               receivetarget.getTeamname().equals(temp.getTeamname()) &&
               receivetarget.getContactphonenumber().equals(temp.getContactphonenumber()),"您暂未修改信息!");

        /* 2.设置默认值 */
        receivetarget.setTargettypeid(receivetarget.getTargettypeid());

        /* 3.调用更新方法,返回受影响的行数 */
        AssertUtil.isTrue(receivetargetMapper.updateByPrimaryKeySelective(receivetarget)!=1,"团队信息修改失败!");
    }
}
