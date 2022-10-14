package com.xxxx.hotel.vo;

public class Passenger {
    private Integer id;  // 旅客ID

    private Integer papersid; // 证件ID

    private Integer educationdegreeid; // 文化程度ID

    private Integer genderid; // 性别ID

    private Integer passengerlevelid; // 旅客级别ID

    private Integer nationid; // 民族ID

    private Integer thingreasonid; //  事由

    private String name; // 姓名

    private String papersnumber; //  证件号码

    private String birthdate; // 出生日期

    private String licenceissuingauthorty; // 发证机关

    private String unitsoraddress; // 单位或住址

    private String papersvalidity; // 证件有效期

    private String profession; // 职业

    private String wherearefrom; // 从何处来

    private String wheretogo; // 到哪里去

    private String contactphonenumber; // 联系电话

    private String remarks; // 备注

    public Integer isvalid; // 是否有效

    private String papersName; // 证件类型
    private String educationDegreeName;// 文化程度
    private String genderName;//性别
    private String passengerLevelName;//旅客级别
    private String nationName;//民族
    private String thingReasonName;//事由

    public Integer getIsvalid() {
        return isvalid;
    }

    public void setIsvalid(Integer isvalid) {
        this.isvalid = isvalid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPapersid() {
        return papersid;
    }

    public void setPapersid(Integer papersid) {
        this.papersid = papersid;
    }

    public Integer getEducationdegreeid() {
        return educationdegreeid;
    }

    public void setEducationdegreeid(Integer educationdegreeid) {
        this.educationdegreeid = educationdegreeid;
    }

    public Integer getGenderid() {
        return genderid;
    }

    public void setGenderid(Integer genderid) {
        this.genderid = genderid;
    }

    public Integer getPassengerlevelid() {
        return passengerlevelid;
    }

    public void setPassengerlevelid(Integer passengerlevelid) {
        this.passengerlevelid = passengerlevelid;
    }

    public Integer getNationid() {
        return nationid;
    }

    public void setNationid(Integer nationid) {
        this.nationid = nationid;
    }

    public Integer getThingreasonid() {
        return thingreasonid;
    }

    public void setThingreasonid(Integer thingreasonid) {
        this.thingreasonid = thingreasonid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPapersnumber() {
        return papersnumber;
    }

    public void setPapersnumber(String papersnumber) {
        this.papersnumber = papersnumber == null ? null : papersnumber.trim();
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate == null ? null : birthdate.trim();
    }

    public String getLicenceissuingauthorty() {
        return licenceissuingauthorty;
    }

    public void setLicenceissuingauthorty(String licenceissuingauthorty) {
        this.licenceissuingauthorty = licenceissuingauthorty == null ? null : licenceissuingauthorty.trim();
    }

    public String getUnitsoraddress() {
        return unitsoraddress;
    }

    public void setUnitsoraddress(String unitsoraddress) {
        this.unitsoraddress = unitsoraddress == null ? null : unitsoraddress.trim();
    }

    public String getPapersvalidity() {
        return papersvalidity;
    }

    public void setPapersvalidity(String papersvalidity) {
        this.papersvalidity = papersvalidity == null ? null : papersvalidity.trim();
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession == null ? null : profession.trim();
    }

    public String getWherearefrom() {
        return wherearefrom;
    }

    public void setWherearefrom(String wherearefrom) {
        this.wherearefrom = wherearefrom == null ? null : wherearefrom.trim();
    }

    public String getWheretogo() {
        return wheretogo;
    }

    public void setWheretogo(String wheretogo) {
        this.wheretogo = wheretogo == null ? null : wheretogo.trim();
    }

    public String getContactphonenumber() {
        return contactphonenumber;
    }

    public void setContactphonenumber(String contactphonenumber) {
        this.contactphonenumber = contactphonenumber == null ? null : contactphonenumber.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getPapersName() {
        return papersName;
    }

    public void setPapersName(String papersName) {
        this.papersName = papersName;
    }

    public String getEducationDegreeName() {
        return educationDegreeName;
    }

    public void setEducationDegreeName(String educationDegreeName) {
        this.educationDegreeName = educationDegreeName;
    }

    public String getGenderName() {
        return genderName;
    }

    public void setGenderName(String genderName) {
        this.genderName = genderName;
    }

    public String getPassengerLevelName() {
        return passengerLevelName;
    }

    public void setPassengerLevelName(String passengerLevelName) {
        this.passengerLevelName = passengerLevelName;
    }

    public String getNationName() {
        return nationName;
    }

    public void setNationName(String nationName) {
        this.nationName = nationName;
    }

    public String getThingReasonName() {
        return thingReasonName;
    }

    public void setThingReasonName(String thingReasonName) {
        this.thingReasonName = thingReasonName;
    }
}