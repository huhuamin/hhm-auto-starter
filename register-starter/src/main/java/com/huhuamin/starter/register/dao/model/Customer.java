package com.huhuamin.starter.register.dao.model;

import com.huhuamin.mybatis.type.handler.GeoPoint;
import com.huhuamin.starter.register.dao.extra.CustomerExtra;

import java.util.Date;

/**
 * 胡化敏代码生成器.
 * 数据库表名 clzah_basic_customer_base
 *
 * @mbg.generated do_not_delete_during_merge Fri Feb 28 14:12:14 CST 2020
 */
public class Customer extends CustomerExtra {
    /**
     * 主键
     * <p>
     * 数据库字段名:clzah_basic_customer_base.CUST_ID
     *
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    private String custId;

    /**
     * 客户类型[1-雇主 2-工人 3-普通会员]
     * <p>
     * 数据库字段名:clzah_basic_customer_base.CUST_TYPE
     *
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    private Integer custType;

    /**
     * 登录密码
     * <p>
     * 数据库字段名:clzah_basic_customer_base.LOGIN_PWD
     *
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    private String loginPwd;

    /**
     * 手机号
     * <p>
     * 数据库字段名:clzah_basic_customer_base.CUST_PHONE
     *
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    private String custPhone;

    /**
     * 性别[1-男 2-女 3-未知 4-保密]
     * <p>
     * 数据库字段名:clzah_basic_customer_base.CUST_SEX
     *
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    private Byte custSex;

    /**
     * 所在区域路径
     * <p>
     * 数据库字段名:clzah_basic_customer_base.AREA_PATH
     *
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    private String areaPath;

    /**
     * 邮箱
     * <p>
     * 数据库字段名:clzah_basic_customer_base.CUST_EMAIL
     *
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    private String custEmail;

    /**
     * 昵称
     * <p>
     * 数据库字段名:clzah_basic_customer_base.NICK_NAME
     *
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    private String nickName;

    /**
     * 真实姓名
     * <p>
     * 数据库字段名:clzah_basic_customer_base.REAL_NAME
     *
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    private String realName;

    /**
     * 头像
     * <p>
     * 数据库字段名:clzah_basic_customer_base.HEAD_IMG
     *
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    private String headImg;

    /**
     * 冻结状态[3-冻结 4-正常]
     * <p>
     * 数据库字段名:clzah_basic_customer_base.FREEZE_STATUS
     *
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    private Byte freezeStatus;

    /**
     * 极光推送ID
     * <p>
     * 数据库字段名:clzah_basic_customer_base.PUSH_ID
     *
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    private String pushId;

    /**
     * 邀请人
     * <p>
     * 数据库字段名:clzah_basic_customer_base.INVITER_CODE
     *
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    private String inviterCode;

    /**
     * 注册来源[1-微信 2-WAP 3-Android 4-iOS 5-pc 6-手动创建 7-小程序]
     * <p>
     * 数据库字段名:clzah_basic_customer_base.REGIST_SOURCE
     *
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    private Byte registSource;

    /**
     * 注册时间
     * <p>
     * 数据库字段名:clzah_basic_customer_base.REGIST_TIME
     *
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    private Date registTime;

    /**
     * 登错次数
     * <p>
     * 数据库字段名:clzah_basic_customer_base.ERR_TIMES
     *
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    private Byte errTimes;

    /**
     * 最后登错时间
     * <p>
     * 数据库字段名:clzah_basic_customer_base.ERR_TIME
     *
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    private Date errTime;

    /**
     * 最近一次登录时间
     * <p>
     * 数据库字段名:clzah_basic_customer_base.LOGIN_TIME
     *
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    private Date loginTime;

    /**
     * 出生日期
     * <p>
     * 数据库字段名:clzah_basic_customer_base.BIRTH_DATE
     *
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    private Date birthDate;

    /**
     * 邀请码
     * <p>
     * 数据库字段名:clzah_basic_customer_base.INVITE_CODE
     *
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    private String inviteCode;

    /**
     * 删除标记[1-正常 2-删除]
     * <p>
     * 数据库字段名:clzah_basic_customer_base.DEL_FLAG
     *
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    private Byte delFlag;

    /**
     * 数据库字段名:clzah_basic_customer_base.MAP_HASH
     *
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    private String mapHash;

    /**
     * 实时定位（省市区）
     * <p>
     * 数据库字段名:clzah_basic_customer_base.MAP_AREA
     *
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    private String mapArea;

    /**
     * 实时位置(经度,维度)
     * <p>
     * 数据库字段名:clzah_basic_customer_base.MAP_COORD
     *
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    private GeoPoint mapCoord;

    /**
     * 数据库字段：主键clzah_basic_customer_base.CUST_ID
     *
     * @return the value of clzah_basic_customer_base.CUST_ID
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    public String getCustId() {
        return custId;
    }

    /**
     * 数据库字段：主键clzah_basic_customer_base.CUST_ID
     *
     * @param custId the value for clzah_basic_customer_base.CUST_ID
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    /**
     * 数据库字段：客户类型[1-雇主 2-工人 3-普通会员]clzah_basic_customer_base.CUST_TYPE
     *
     * @return the value of clzah_basic_customer_base.CUST_TYPE
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    public Integer getCustType() {
        return custType;
    }

    /**
     * 数据库字段：客户类型[1-雇主 2-工人 3-普通会员]clzah_basic_customer_base.CUST_TYPE
     *
     * @param custType the value for clzah_basic_customer_base.CUST_TYPE
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    public void setCustType(Integer custType) {
        this.custType = custType;
    }

    /**
     * 数据库字段：登录密码clzah_basic_customer_base.LOGIN_PWD
     *
     * @return the value of clzah_basic_customer_base.LOGIN_PWD
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    public String getLoginPwd() {
        return loginPwd;
    }

    /**
     * 数据库字段：登录密码clzah_basic_customer_base.LOGIN_PWD
     *
     * @param loginPwd the value for clzah_basic_customer_base.LOGIN_PWD
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd == null ? null : loginPwd.trim();
    }

    /**
     * 数据库字段：手机号clzah_basic_customer_base.CUST_PHONE
     *
     * @return the value of clzah_basic_customer_base.CUST_PHONE
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    public String getCustPhone() {
        return custPhone;
    }

    /**
     * 数据库字段：手机号clzah_basic_customer_base.CUST_PHONE
     *
     * @param custPhone the value for clzah_basic_customer_base.CUST_PHONE
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone == null ? null : custPhone.trim();
    }

    /**
     * 数据库字段：性别[1-男 2-女 3-未知 4-保密]clzah_basic_customer_base.CUST_SEX
     *
     * @return the value of clzah_basic_customer_base.CUST_SEX
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    public Byte getCustSex() {
        return custSex;
    }

    /**
     * 数据库字段：性别[1-男 2-女 3-未知 4-保密]clzah_basic_customer_base.CUST_SEX
     *
     * @param custSex the value for clzah_basic_customer_base.CUST_SEX
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    public void setCustSex(Byte custSex) {
        this.custSex = custSex;
    }

    /**
     * 数据库字段：所在区域路径clzah_basic_customer_base.AREA_PATH
     *
     * @return the value of clzah_basic_customer_base.AREA_PATH
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    public String getAreaPath() {
        return areaPath;
    }

    /**
     * 数据库字段：所在区域路径clzah_basic_customer_base.AREA_PATH
     *
     * @param areaPath the value for clzah_basic_customer_base.AREA_PATH
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    public void setAreaPath(String areaPath) {
        this.areaPath = areaPath == null ? null : areaPath.trim();
    }

    /**
     * 数据库字段：邮箱clzah_basic_customer_base.CUST_EMAIL
     *
     * @return the value of clzah_basic_customer_base.CUST_EMAIL
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    public String getCustEmail() {
        return custEmail;
    }

    /**
     * 数据库字段：邮箱clzah_basic_customer_base.CUST_EMAIL
     *
     * @param custEmail the value for clzah_basic_customer_base.CUST_EMAIL
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail == null ? null : custEmail.trim();
    }

    /**
     * 数据库字段：昵称clzah_basic_customer_base.NICK_NAME
     *
     * @return the value of clzah_basic_customer_base.NICK_NAME
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 数据库字段：昵称clzah_basic_customer_base.NICK_NAME
     *
     * @param nickName the value for clzah_basic_customer_base.NICK_NAME
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * 数据库字段：真实姓名clzah_basic_customer_base.REAL_NAME
     *
     * @return the value of clzah_basic_customer_base.REAL_NAME
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 数据库字段：真实姓名clzah_basic_customer_base.REAL_NAME
     *
     * @param realName the value for clzah_basic_customer_base.REAL_NAME
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * 数据库字段：头像clzah_basic_customer_base.HEAD_IMG
     *
     * @return the value of clzah_basic_customer_base.HEAD_IMG
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    public String getHeadImg() {
        return headImg;
    }

    /**
     * 数据库字段：头像clzah_basic_customer_base.HEAD_IMG
     *
     * @param headImg the value for clzah_basic_customer_base.HEAD_IMG
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    public void setHeadImg(String headImg) {
        this.headImg = headImg == null ? null : headImg.trim();
    }

    /**
     * 数据库字段：冻结状态[3-冻结 4-正常]clzah_basic_customer_base.FREEZE_STATUS
     *
     * @return the value of clzah_basic_customer_base.FREEZE_STATUS
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    public Byte getFreezeStatus() {
        return freezeStatus;
    }

    /**
     * 数据库字段：冻结状态[3-冻结 4-正常]clzah_basic_customer_base.FREEZE_STATUS
     *
     * @param freezeStatus the value for clzah_basic_customer_base.FREEZE_STATUS
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    public void setFreezeStatus(Byte freezeStatus) {
        this.freezeStatus = freezeStatus;
    }

    /**
     * 数据库字段：极光推送IDclzah_basic_customer_base.PUSH_ID
     *
     * @return the value of clzah_basic_customer_base.PUSH_ID
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    public String getPushId() {
        return pushId;
    }

    /**
     * 数据库字段：极光推送IDclzah_basic_customer_base.PUSH_ID
     *
     * @param pushId the value for clzah_basic_customer_base.PUSH_ID
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    public void setPushId(String pushId) {
        this.pushId = pushId == null ? null : pushId.trim();
    }

    /**
     * 数据库字段：邀请人clzah_basic_customer_base.INVITER_CODE
     *
     * @return the value of clzah_basic_customer_base.INVITER_CODE
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    public String getInviterCode() {
        return inviterCode;
    }

    /**
     * 数据库字段：邀请人clzah_basic_customer_base.INVITER_CODE
     *
     * @param inviterCode the value for clzah_basic_customer_base.INVITER_CODE
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    public void setInviterCode(String inviterCode) {
        this.inviterCode = inviterCode == null ? null : inviterCode.trim();
    }

    /**
     * 数据库字段：注册来源[1-微信 2-WAP 3-Android 4-iOS 5-pc 6-手动创建 7-小程序]clzah_basic_customer_base.REGIST_SOURCE
     *
     * @return the value of clzah_basic_customer_base.REGIST_SOURCE
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    public Byte getRegistSource() {
        return registSource;
    }

    /**
     * 数据库字段：注册来源[1-微信 2-WAP 3-Android 4-iOS 5-pc 6-手动创建 7-小程序]clzah_basic_customer_base.REGIST_SOURCE
     *
     * @param registSource the value for clzah_basic_customer_base.REGIST_SOURCE
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    public void setRegistSource(Byte registSource) {
        this.registSource = registSource;
    }

    /**
     * 数据库字段：注册时间clzah_basic_customer_base.REGIST_TIME
     *
     * @return the value of clzah_basic_customer_base.REGIST_TIME
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    public Date getRegistTime() {
        return registTime;
    }

    /**
     * 数据库字段：注册时间clzah_basic_customer_base.REGIST_TIME
     *
     * @param registTime the value for clzah_basic_customer_base.REGIST_TIME
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    public void setRegistTime(Date registTime) {
        this.registTime = registTime;
    }

    /**
     * 数据库字段：登错次数clzah_basic_customer_base.ERR_TIMES
     *
     * @return the value of clzah_basic_customer_base.ERR_TIMES
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    public Byte getErrTimes() {
        return errTimes;
    }

    /**
     * 数据库字段：登错次数clzah_basic_customer_base.ERR_TIMES
     *
     * @param errTimes the value for clzah_basic_customer_base.ERR_TIMES
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    public void setErrTimes(Byte errTimes) {
        this.errTimes = errTimes;
    }

    /**
     * 数据库字段：最后登错时间clzah_basic_customer_base.ERR_TIME
     *
     * @return the value of clzah_basic_customer_base.ERR_TIME
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    public Date getErrTime() {
        return errTime;
    }

    /**
     * 数据库字段：最后登错时间clzah_basic_customer_base.ERR_TIME
     *
     * @param errTime the value for clzah_basic_customer_base.ERR_TIME
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    public void setErrTime(Date errTime) {
        this.errTime = errTime;
    }

    /**
     * 数据库字段：最近一次登录时间clzah_basic_customer_base.LOGIN_TIME
     *
     * @return the value of clzah_basic_customer_base.LOGIN_TIME
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * 数据库字段：最近一次登录时间clzah_basic_customer_base.LOGIN_TIME
     *
     * @param loginTime the value for clzah_basic_customer_base.LOGIN_TIME
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    /**
     * 数据库字段：出生日期clzah_basic_customer_base.BIRTH_DATE
     *
     * @return the value of clzah_basic_customer_base.BIRTH_DATE
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * 数据库字段：出生日期clzah_basic_customer_base.BIRTH_DATE
     *
     * @param birthDate the value for clzah_basic_customer_base.BIRTH_DATE
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * 数据库字段：邀请码clzah_basic_customer_base.INVITE_CODE
     *
     * @return the value of clzah_basic_customer_base.INVITE_CODE
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    public String getInviteCode() {
        return inviteCode;
    }

    /**
     * 数据库字段：邀请码clzah_basic_customer_base.INVITE_CODE
     *
     * @param inviteCode the value for clzah_basic_customer_base.INVITE_CODE
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode == null ? null : inviteCode.trim();
    }

    /**
     * 数据库字段：删除标记[1-正常 2-删除]clzah_basic_customer_base.DEL_FLAG
     *
     * @return the value of clzah_basic_customer_base.DEL_FLAG
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    public Byte getDelFlag() {
        return delFlag;
    }

    /**
     * 数据库字段：删除标记[1-正常 2-删除]clzah_basic_customer_base.DEL_FLAG
     *
     * @param delFlag the value for clzah_basic_customer_base.DEL_FLAG
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    public void setDelFlag(Byte delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * 数据库字段：clzah_basic_customer_base.MAP_HASH
     *
     * @return the value of clzah_basic_customer_base.MAP_HASH
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    public String getMapHash() {
        return mapHash;
    }

    /**
     * 数据库字段：clzah_basic_customer_base.MAP_HASH
     *
     * @param mapHash the value for clzah_basic_customer_base.MAP_HASH
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    public void setMapHash(String mapHash) {
        this.mapHash = mapHash == null ? null : mapHash.trim();
    }

    /**
     * 数据库字段：实时定位（省市区）clzah_basic_customer_base.MAP_AREA
     *
     * @return the value of clzah_basic_customer_base.MAP_AREA
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    public String getMapArea() {
        return mapArea;
    }

    /**
     * 数据库字段：实时定位（省市区）clzah_basic_customer_base.MAP_AREA
     *
     * @param mapArea the value for clzah_basic_customer_base.MAP_AREA
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    public void setMapArea(String mapArea) {
        this.mapArea = mapArea == null ? null : mapArea.trim();
    }

    /**
     * 数据库字段：实时位置(经度,维度)clzah_basic_customer_base.MAP_COORD
     *
     * @return the value of clzah_basic_customer_base.MAP_COORD
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    public GeoPoint getMapCoord() {
        return mapCoord;
    }

    /**
     * 数据库字段：实时位置(经度,维度)clzah_basic_customer_base.MAP_COORD
     *
     * @param mapCoord the value for clzah_basic_customer_base.MAP_COORD
     * @mbg.generated Fri Feb 28 14:12:14 CST 2020
     */
    public void setMapCoord(GeoPoint mapCoord) {
        this.mapCoord = mapCoord;
    }
}