package com.xxxx.hotel.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class PassengersComments {
    private Integer id;

    private Integer passengerid;

    private Integer evaluationlevelid;

    private String evaluationlevelName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date evaluationdate;

    private String evaluationtext;

    private Integer isvalid;

    private String name; // 姓名


    public String getEvaluationlevelName() {
        return evaluationlevelName;
    }

    public void setEvaluationlevelName(String evaluationlevelName) {
        this.evaluationlevelName = evaluationlevelName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPassengerid() {
        return passengerid;
    }

    public void setPassengerid(Integer passengerid) {
        this.passengerid = passengerid;
    }

    public Integer getEvaluationlevelid() {
        return evaluationlevelid;
    }

    public void setEvaluationlevelid(Integer evaluationlevelid) {
        this.evaluationlevelid = evaluationlevelid;
    }

    public Date getEvaluationdate() {
        return evaluationdate;
    }

    public void setEvaluationdate(Date evaluationdate) {
        this.evaluationdate = evaluationdate;
    }

    public String getEvaluationtext() {
        return evaluationtext;
    }

    public void setEvaluationtext(String evaluationtext) {
        this.evaluationtext = evaluationtext == null ? null : evaluationtext.trim();
    }

    public Integer getIsvalid() {
        return isvalid;
    }

    public void setIsvalid(Integer isvalid) {
        this.isvalid = isvalid;
    }
}