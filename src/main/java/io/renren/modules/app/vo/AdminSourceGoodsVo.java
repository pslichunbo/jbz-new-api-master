package io.renren.modules.app.vo;

import java.math.BigDecimal;
import java.util.Date;

public class AdminSourceGoodsVo {
    //订单id
    private Long Id;
    //货主
    private String shipperName;
    //货主电话
    private String shipperPhone;
    //出发地
    private String startAddress;
    //目的地
    private String endAddress;
    //订单号
    private String orderNumber;
    //状态
    private Long state;
    //出发地详细地址
    private String startMinuteAddress;
    //目的地详细地址
    private String endMinuteAddress;
    //接单时间
    private Date orderTime;
    //送达时间
    private Date arriveTime;
   //拉货人
    private String orderUserName;
    //拉货人电话
    private String orderUserPhone;
    //估重
    private Double weight;
    //估价
    private String evaluate;
    //备注
    private String remark;
    //货源id
    private Long goodsId;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getShipperName() {
        return shipperName;
    }

    public void setShipperName(String shipperName) {
        this.shipperName = shipperName;
    }

    public String getShipperPhone() {
        return shipperPhone;
    }

    public void setShipperPhone(String shipperPhone) {
        this.shipperPhone = shipperPhone;
    }

    public String getStartAddress() {
        return startAddress;
    }

    public void setStartAddress(String startAddress) {
        this.startAddress = startAddress;
    }

    public String getEndAddress() {
        return endAddress;
    }

    public void setEndAddress(String endAddress) {
        this.endAddress = endAddress;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Long getState() {
        return state;
    }

    public void setState(Long state) {
        this.state = state;
    }

    public String getStartMinuteAddress() {
        return startMinuteAddress;
    }

    public void setStartMinuteAddress(String startMinuteAddress) {
        this.startMinuteAddress = startMinuteAddress;
    }

    public String getEndMinuteAddress() {
        return endMinuteAddress;
    }

    public void setEndMinuteAddress(String endMinuteAddress) {
        this.endMinuteAddress = endMinuteAddress;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Date arriveTime) {
        this.arriveTime = arriveTime;
    }

    public String getOrderUserName() {
        return orderUserName;
    }

    public void setOrderUserName(String orderUserName) {
        this.orderUserName = orderUserName;
    }

    public String getOrderUserPhone() {
        return orderUserPhone;
    }

    public void setOrderUserPhone(String orderUserPhone) {
        this.orderUserPhone = orderUserPhone;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
