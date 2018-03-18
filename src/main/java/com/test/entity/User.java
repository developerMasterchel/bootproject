package com.test.entity;

import java.util.Date;

import com.commons.page.Page;

public class User extends Page{
    /**   */
	private static final long serialVersionUID = -1313246645095890978L;

	private String id;

    private String nickName;

    private String sex;

    private Short age;

    private Date createTime;

    private Date lastLoginTime;

    private String passWord;

    private String email;

    private String telphone;

    private String mobiphone;

    private String certificationStatus;

    private String certification;

    private Short vipLevel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord == null ? null : passWord.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone == null ? null : telphone.trim();
    }

    public String getMobiphone() {
        return mobiphone;
    }

    public void setMobiphone(String mobiphone) {
        this.mobiphone = mobiphone == null ? null : mobiphone.trim();
    }

    public String getCertificationStatus() {
        return certificationStatus;
    }

    public void setCertificationStatus(String certificationStatus) {
        this.certificationStatus = certificationStatus == null ? null : certificationStatus.trim();
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification == null ? null : certification.trim();
    }

    public Short getVipLevel() {
        return vipLevel;
    }

    public void setVipLevel(Short vipLevel) {
        this.vipLevel = vipLevel;
    }
}