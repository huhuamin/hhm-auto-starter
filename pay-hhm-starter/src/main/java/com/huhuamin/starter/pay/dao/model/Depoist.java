package com.huhuamin.starter.pay.dao.model;

import java.util.Date;

/**
 *
 * 胡化敏代码生成器.
 * 数据库表名 clzah_bussiness_depoist_base
 *
 * @mbg.generated do_not_delete_during_merge Fri Mar 06 23:29:22 CST 2020
 */
public class Depoist {
    /**
     *   主键
     *
     * 数据库字段名:clzah_bussiness_depoist_base.DEPOSIT_ID
     *
     * @mbg.generated Fri Mar 06 23:29:22 CST 2020
     */
    private String depositId;

    /**
     *   保证金类别[1-个人 2-企业]
     *
     * 数据库字段名:clzah_bussiness_depoist_base.DEPOSIT_TYPE
     *
     * @mbg.generated Fri Mar 06 23:29:22 CST 2020
     */
    private Byte depositType;

    /**
     *   客户ID
     *
     * 数据库字段名:clzah_bussiness_depoist_base.CUST_ID
     *
     * @mbg.generated Fri Mar 06 23:29:22 CST 2020
     */
    private String custId;

    /**
     *   供应商类型ID(冗余)
     *
     * 数据库字段名:clzah_bussiness_depoist_base.SUPPLIER_ID
     *
     * @mbg.generated Fri Mar 06 23:29:22 CST 2020
     */
    private String supplierId;

    /**
     *   订单编号
     *
     * 数据库字段名:clzah_bussiness_depoist_base.ORDER_NO
     *
     * @mbg.generated Fri Mar 06 23:29:22 CST 2020
     */
    private String orderNo;

    /**
     *   流水号
     *
     * 数据库字段名:clzah_bussiness_depoist_base.SERIAL_NO
     *
     * @mbg.generated Fri Mar 06 23:29:22 CST 2020
     */
    private String serialNo;

    /**
     *   保证金金额
     *
     * 数据库字段名:clzah_bussiness_depoist_base.ORDER_AMT
     *
     * @mbg.generated Fri Mar 06 23:29:22 CST 2020
     */
    private Double orderAmt;

    /**
     *   支付方式[1-支付宝 2-微信]
     *
     * 数据库字段名:clzah_bussiness_depoist_base.ORDER_SOURCE
     *
     * @mbg.generated Fri Mar 06 23:29:22 CST 2020
     */
    private Byte orderSource;

    /**
     *   添加时间
     *
     * 数据库字段名:clzah_bussiness_depoist_base.ADD_TIME
     *
     * @mbg.generated Fri Mar 06 23:29:22 CST 2020
     */
    private Date addTime;

    /**
     *   保证金有效时间
     *
     * 数据库字段名:clzah_bussiness_depoist_base.EFFECTY_TIME
     *
     * @mbg.generated Fri Mar 06 23:29:22 CST 2020
     */
    private Date effectyTime;

    /**
     *   付款状态[1-待付款 2-已付款 3-已退款 4-退款异常 5-手动扣完]
     *
     * 数据库字段名:clzah_bussiness_depoist_base.DEPOSIT_STATUS
     *
     * @mbg.generated Fri Mar 06 23:29:22 CST 2020
     */
    private Byte depositStatus;

    /**
     *   退款订单号
     *
     * 数据库字段名:clzah_bussiness_depoist_base.REFUND_NO
     *
     * @mbg.generated Fri Mar 06 23:29:22 CST 2020
     */
    private String refundNo;

    /**
     *   退款时间
     *
     * 数据库字段名:clzah_bussiness_depoist_base.REFUND_TIME
     *
     * @mbg.generated Fri Mar 06 23:29:22 CST 2020
     */
    private Date refundTime;

    /**
     *   退款金额
     *
     * 数据库字段名:clzah_bussiness_depoist_base.REFUND_AMT
     *
     * @mbg.generated Fri Mar 06 23:29:22 CST 2020
     */
    private Double refundAmt;

    /**
     *   退款描述
     *
     * 数据库字段名:clzah_bussiness_depoist_base.REFUND_DESC
     *
     * @mbg.generated Fri Mar 06 23:29:22 CST 2020
     */
    private String refundDesc;

    /**
     *   应扣除佣金金额
     *
     * 数据库字段名:clzah_bussiness_depoist_base.BROKER_AMT
     *
     * @mbg.generated Fri Mar 06 23:29:22 CST 2020
     */
    private Double brokerAmt;

    /**
     *   违规扣除金额
     *
     * 数据库字段名:clzah_bussiness_depoist_base.ILLEGAL_AMT
     *
     * @mbg.generated Fri Mar 06 23:29:22 CST 2020
     */
    private Double illegalAmt;

    /**
     * 数据库字段：主键clzah_bussiness_depoist_base.DEPOSIT_ID
     *
     * @return  the value of clzah_bussiness_depoist_base.DEPOSIT_ID
     *
     * @mbg.generated Fri Mar 06 23:29:22 CST 2020
     */
    public String getDepositId() {
        return depositId;
    }

    /**
     * 数据库字段：主键clzah_bussiness_depoist_base.DEPOSIT_ID
     * @param depositId the value for clzah_bussiness_depoist_base.DEPOSIT_ID
     *
     * @mbg.generated Fri Mar 06 23:29:22 CST 2020
     */
    public void setDepositId(String depositId) {
        this.depositId = depositId == null ? null : depositId.trim();
    }

    /**
     * 数据库字段：保证金类别[1-个人 2-企业]clzah_bussiness_depoist_base.DEPOSIT_TYPE
     *
     * @return  the value of clzah_bussiness_depoist_base.DEPOSIT_TYPE
     *
     * @mbg.generated Fri Mar 06 23:29:22 CST 2020
     */
    public Byte getDepositType() {
        return depositType;
    }

    /**
     * 数据库字段：保证金类别[1-个人 2-企业]clzah_bussiness_depoist_base.DEPOSIT_TYPE
     * @param depositType the value for clzah_bussiness_depoist_base.DEPOSIT_TYPE
     *
     * @mbg.generated Fri Mar 06 23:29:22 CST 2020
     */
    public void setDepositType(Byte depositType) {
        this.depositType = depositType;
    }

    /**
     * 数据库字段：客户IDclzah_bussiness_depoist_base.CUST_ID
     *
     * @return  the value of clzah_bussiness_depoist_base.CUST_ID
     *
     * @mbg.generated Fri Mar 06 23:29:22 CST 2020
     */
    public String getCustId() {
        return custId;
    }

    /**
     * 数据库字段：客户IDclzah_bussiness_depoist_base.CUST_ID
     * @param custId the value for clzah_bussiness_depoist_base.CUST_ID
     *
     * @mbg.generated Fri Mar 06 23:29:22 CST 2020
     */
    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    /**
     * 数据库字段：供应商类型ID(冗余)clzah_bussiness_depoist_base.SUPPLIER_ID
     *
     * @return  the value of clzah_bussiness_depoist_base.SUPPLIER_ID
     *
     * @mbg.generated Fri Mar 06 23:29:22 CST 2020
     */
    public String getSupplierId() {
        return supplierId;
    }

    /**
     * 数据库字段：供应商类型ID(冗余)clzah_bussiness_depoist_base.SUPPLIER_ID
     * @param supplierId the value for clzah_bussiness_depoist_base.SUPPLIER_ID
     *
     * @mbg.generated Fri Mar 06 23:29:22 CST 2020
     */
    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId == null ? null : supplierId.trim();
    }

    /**
     * 数据库字段：订单编号clzah_bussiness_depoist_base.ORDER_NO
     *
     * @return  the value of clzah_bussiness_depoist_base.ORDER_NO
     *
     * @mbg.generated Fri Mar 06 23:29:22 CST 2020
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * 数据库字段：订单编号clzah_bussiness_depoist_base.ORDER_NO
     * @param orderNo the value for clzah_bussiness_depoist_base.ORDER_NO
     *
     * @mbg.generated Fri Mar 06 23:29:22 CST 2020
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    /**
     * 数据库字段：流水号clzah_bussiness_depoist_base.SERIAL_NO
     *
     * @return  the value of clzah_bussiness_depoist_base.SERIAL_NO
     *
     * @mbg.generated Fri Mar 06 23:29:22 CST 2020
     */
    public String getSerialNo() {
        return serialNo;
    }

    /**
     * 数据库字段：流水号clzah_bussiness_depoist_base.SERIAL_NO
     * @param serialNo the value for clzah_bussiness_depoist_base.SERIAL_NO
     *
     * @mbg.generated Fri Mar 06 23:29:22 CST 2020
     */
    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo == null ? null : serialNo.trim();
    }

    /**
     * 数据库字段：保证金金额clzah_bussiness_depoist_base.ORDER_AMT
     *
     * @return  the value of clzah_bussiness_depoist_base.ORDER_AMT
     *
     * @mbg.generated Fri Mar 06 23:29:22 CST 2020
     */
    public Double getOrderAmt() {
        return orderAmt;
    }

    /**
     * 数据库字段：保证金金额clzah_bussiness_depoist_base.ORDER_AMT
     * @param orderAmt the value for clzah_bussiness_depoist_base.ORDER_AMT
     *
     * @mbg.generated Fri Mar 06 23:29:22 CST 2020
     */
    public void setOrderAmt(Double orderAmt) {
        this.orderAmt = orderAmt;
    }

    /**
     * 数据库字段：支付方式[1-支付宝 2-微信]clzah_bussiness_depoist_base.ORDER_SOURCE
     *
     * @return  the value of clzah_bussiness_depoist_base.ORDER_SOURCE
     *
     * @mbg.generated Fri Mar 06 23:29:22 CST 2020
     */
    public Byte getOrderSource() {
        return orderSource;
    }

    /**
     * 数据库字段：支付方式[1-支付宝 2-微信]clzah_bussiness_depoist_base.ORDER_SOURCE
     * @param orderSource the value for clzah_bussiness_depoist_base.ORDER_SOURCE
     *
     * @mbg.generated Fri Mar 06 23:29:22 CST 2020
     */
    public void setOrderSource(Byte orderSource) {
        this.orderSource = orderSource;
    }

    /**
     * 数据库字段：添加时间clzah_bussiness_depoist_base.ADD_TIME
     *
     * @return  the value of clzah_bussiness_depoist_base.ADD_TIME
     *
     * @mbg.generated Fri Mar 06 23:29:22 CST 2020
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 数据库字段：添加时间clzah_bussiness_depoist_base.ADD_TIME
     * @param addTime the value for clzah_bussiness_depoist_base.ADD_TIME
     *
     * @mbg.generated Fri Mar 06 23:29:22 CST 2020
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 数据库字段：保证金有效时间clzah_bussiness_depoist_base.EFFECTY_TIME
     *
     * @return  the value of clzah_bussiness_depoist_base.EFFECTY_TIME
     *
     * @mbg.generated Fri Mar 06 23:29:22 CST 2020
     */
    public Date getEffectyTime() {
        return effectyTime;
    }

    /**
     * 数据库字段：保证金有效时间clzah_bussiness_depoist_base.EFFECTY_TIME
     * @param effectyTime the value for clzah_bussiness_depoist_base.EFFECTY_TIME
     *
     * @mbg.generated Fri Mar 06 23:29:22 CST 2020
     */
    public void setEffectyTime(Date effectyTime) {
        this.effectyTime = effectyTime;
    }

    /**
     * 数据库字段：付款状态[1-待付款 2-已付款 3-已退款 4-退款异常 5-手动扣完]clzah_bussiness_depoist_base.DEPOSIT_STATUS
     *
     * @return  the value of clzah_bussiness_depoist_base.DEPOSIT_STATUS
     *
     * @mbg.generated Fri Mar 06 23:29:22 CST 2020
     */
    public Byte getDepositStatus() {
        return depositStatus;
    }

    /**
     * 数据库字段：付款状态[1-待付款 2-已付款 3-已退款 4-退款异常 5-手动扣完]clzah_bussiness_depoist_base.DEPOSIT_STATUS
     * @param depositStatus the value for clzah_bussiness_depoist_base.DEPOSIT_STATUS
     *
     * @mbg.generated Fri Mar 06 23:29:22 CST 2020
     */
    public void setDepositStatus(Byte depositStatus) {
        this.depositStatus = depositStatus;
    }

    /**
     * 数据库字段：退款订单号clzah_bussiness_depoist_base.REFUND_NO
     *
     * @return  the value of clzah_bussiness_depoist_base.REFUND_NO
     *
     * @mbg.generated Fri Mar 06 23:29:22 CST 2020
     */
    public String getRefundNo() {
        return refundNo;
    }

    /**
     * 数据库字段：退款订单号clzah_bussiness_depoist_base.REFUND_NO
     * @param refundNo the value for clzah_bussiness_depoist_base.REFUND_NO
     *
     * @mbg.generated Fri Mar 06 23:29:22 CST 2020
     */
    public void setRefundNo(String refundNo) {
        this.refundNo = refundNo == null ? null : refundNo.trim();
    }

    /**
     * 数据库字段：退款时间clzah_bussiness_depoist_base.REFUND_TIME
     *
     * @return  the value of clzah_bussiness_depoist_base.REFUND_TIME
     *
     * @mbg.generated Fri Mar 06 23:29:22 CST 2020
     */
    public Date getRefundTime() {
        return refundTime;
    }

    /**
     * 数据库字段：退款时间clzah_bussiness_depoist_base.REFUND_TIME
     * @param refundTime the value for clzah_bussiness_depoist_base.REFUND_TIME
     *
     * @mbg.generated Fri Mar 06 23:29:22 CST 2020
     */
    public void setRefundTime(Date refundTime) {
        this.refundTime = refundTime;
    }

    /**
     * 数据库字段：退款金额clzah_bussiness_depoist_base.REFUND_AMT
     *
     * @return  the value of clzah_bussiness_depoist_base.REFUND_AMT
     *
     * @mbg.generated Fri Mar 06 23:29:22 CST 2020
     */
    public Double getRefundAmt() {
        return refundAmt;
    }

    /**
     * 数据库字段：退款金额clzah_bussiness_depoist_base.REFUND_AMT
     * @param refundAmt the value for clzah_bussiness_depoist_base.REFUND_AMT
     *
     * @mbg.generated Fri Mar 06 23:29:22 CST 2020
     */
    public void setRefundAmt(Double refundAmt) {
        this.refundAmt = refundAmt;
    }

    /**
     * 数据库字段：退款描述clzah_bussiness_depoist_base.REFUND_DESC
     *
     * @return  the value of clzah_bussiness_depoist_base.REFUND_DESC
     *
     * @mbg.generated Fri Mar 06 23:29:22 CST 2020
     */
    public String getRefundDesc() {
        return refundDesc;
    }

    /**
     * 数据库字段：退款描述clzah_bussiness_depoist_base.REFUND_DESC
     * @param refundDesc the value for clzah_bussiness_depoist_base.REFUND_DESC
     *
     * @mbg.generated Fri Mar 06 23:29:22 CST 2020
     */
    public void setRefundDesc(String refundDesc) {
        this.refundDesc = refundDesc == null ? null : refundDesc.trim();
    }

    /**
     * 数据库字段：应扣除佣金金额clzah_bussiness_depoist_base.BROKER_AMT
     *
     * @return  the value of clzah_bussiness_depoist_base.BROKER_AMT
     *
     * @mbg.generated Fri Mar 06 23:29:22 CST 2020
     */
    public Double getBrokerAmt() {
        return brokerAmt;
    }

    /**
     * 数据库字段：应扣除佣金金额clzah_bussiness_depoist_base.BROKER_AMT
     * @param brokerAmt the value for clzah_bussiness_depoist_base.BROKER_AMT
     *
     * @mbg.generated Fri Mar 06 23:29:22 CST 2020
     */
    public void setBrokerAmt(Double brokerAmt) {
        this.brokerAmt = brokerAmt;
    }

    /**
     * 数据库字段：违规扣除金额clzah_bussiness_depoist_base.ILLEGAL_AMT
     *
     * @return  the value of clzah_bussiness_depoist_base.ILLEGAL_AMT
     *
     * @mbg.generated Fri Mar 06 23:29:22 CST 2020
     */
    public Double getIllegalAmt() {
        return illegalAmt;
    }

    /**
     * 数据库字段：违规扣除金额clzah_bussiness_depoist_base.ILLEGAL_AMT
     * @param illegalAmt the value for clzah_bussiness_depoist_base.ILLEGAL_AMT
     *
     * @mbg.generated Fri Mar 06 23:29:22 CST 2020
     */
    public void setIllegalAmt(Double illegalAmt) {
        this.illegalAmt = illegalAmt;
    }
}