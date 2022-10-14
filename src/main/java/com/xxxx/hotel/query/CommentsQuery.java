package com.xxxx.hotel.query;


import com.xxxx.hotel.base.BaseQuery;


public class CommentsQuery  extends BaseQuery {
    private Integer evaluationlevelID; // 评论级别
    private String startDate;//起始日期
    private String endDate;//结束日期


    public Integer getEvaluationlevelID() {
        return evaluationlevelID;
    }

    public void setEvaluationlevelID(Integer evaluationlevelID) {
        this.evaluationlevelID = evaluationlevelID;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
