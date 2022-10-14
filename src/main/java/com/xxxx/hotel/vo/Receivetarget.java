package com.xxxx.hotel.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.Objects;

public class Receivetarget {
    private Integer id; // 接待对象ID

    private Integer targettypeid; // 接待对象类别ID

    private String principal;// 负责人

    private String teamname; // 团队名称

    private String teamcode; // 团队编号
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date registertime;// 登记时间

    private String contactphonenumber; // 联系电话

    private String isValid;//是否有效

    private String targetTypeName;//团队名称

    public String getIsValid() {
        return isValid;
    }

    public void setIsValid(String isValid) {
        this.isValid = isValid;
    }

    public String getTargetTypeName() {
        return targetTypeName;
    }

    public void setTargetTypeName(String targetTypeName) {
        this.targetTypeName = targetTypeName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTargettypeid() {
        return targettypeid;
    }

    public void setTargettypeid(Integer targettypeid) {
        this.targettypeid = targettypeid;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal == null ? null : principal.trim();
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname == null ? null : teamname.trim();
    }

    public String getTeamcode() {
        return teamcode;
    }

    public void setTeamcode(String teamcode) {
        this.teamcode = teamcode == null ? null : teamcode.trim();
    }

    public Date getRegistertime() {
        return registertime;
    }

    public void setRegistertime(Date registertime) {
        this.registertime = registertime;
    }

    public String getContactphonenumber() {
        return contactphonenumber;
    }

    public void setContactphonenumber(String contactphonenumber) {
        this.contactphonenumber = contactphonenumber == null ? null : contactphonenumber.trim();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receivetarget that = (Receivetarget) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(targettypeid, that.targettypeid) &&
                Objects.equals(principal, that.principal) &&
                Objects.equals(teamname, that.teamname) &&
                Objects.equals(teamcode, that.teamcode) &&
                Objects.equals(registertime, that.registertime) &&
                Objects.equals(contactphonenumber, that.contactphonenumber) &&
                Objects.equals(isValid, that.isValid) &&
                Objects.equals(targetTypeName, that.targetTypeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, targettypeid, principal, teamname, teamcode, registertime, contactphonenumber, isValid, targetTypeName);
    }
}