package com.ao.billms.entities;

import java.util.Date;

/**
 * 帐单实体类
 * @Title: bill
 */
public class Bill {
    //id
    private Integer bid;
    // 账单编码
    private String billCode;
    // 商品名称
    private String billName;
    // 商品单位
    private String billCom;
    // 商品数量
    private Integer billNum;
    // 总金额
    private Double money;
    // 供应商
    private Provider provider;

    private  int pid;


    // 是否付款 0 未付款， 1已付款
    private Integer pay;
    // 创建时间
    private Date createDate;
    public Bill() {}

    public Bill(Integer bid, String billCode, String billName, String billCom, Integer billNum, Double money, Provider provider, Integer pay) {
        this.bid = bid;
        this.billCode = billCode;
        this.billName = billName;
        this.billCom = billCom;
        this.billNum = billNum;
        this.money = money;
        this.provider = provider;
        this.pay = pay;
        this.createDate = new Date();
    }

    @Override
    public String toString() {
        return "Bill{" +
                "bid=" + bid +
                ", billCode='" + billCode + '\'' +
                ", billName='" + billName + '\'' +
                ", billCom='" + billCom + '\'' +
                ", billNum=" + billNum +
                ", money=" + money +
                ", provider=" + provider +
                ", pay=" + pay +
                ", createDate=" + createDate +
                '}';
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }

    public String getBillName() {
        return billName;
    }

    public void setBillName(String billName) {
        this.billName = billName;
    }

    public String getBillCom() {
        return billCom;
    }

    public void setBillCom(String billCom) {
        this.billCom = billCom;
    }

    public Integer getBillNum() {
        return billNum;
    }

    public void setBillNum(Integer billNum) {
        this.billNum = billNum;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Integer getPay() {
        return pay;
    }

    public void setPay(Integer pay) {
        this.pay = pay;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }


    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
}
