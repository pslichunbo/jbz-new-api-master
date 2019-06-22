package io.renren.modules.app.vo;

import java.math.BigDecimal;
import java.util.Date;

public class ApiOrderVo {
    //订单id
    private Long orderId;
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
    //估重
    private String evaluate;
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
    //货物描述
    private String remark;
    //货物图片
    private String[] images;
    //货源创建时间
    private Date createGoodsTime;
    //出发地经度
    private BigDecimal startLongitude;
    //出发地纬度
    private BigDecimal startLatitude;
    //目的地经度
    private BigDecimal endLongitude;
    //目的地纬度
    private BigDecimal endLatitude;
    //是否加急
    private String urgent;
    //接单人数
    private int clerkOrderingNum;
    //货源重量
    private Double weight;

    public String getShipperPhone() {
        return shipperPhone;
    }

    public void setShipperPhone(String shipperPhone) {
        this.shipperPhone = shipperPhone;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public int getClerkOrderingNum() {
        return clerkOrderingNum;
    }

    public void setClerkOrderingNum(int clerkOrderingNum) {
        this.clerkOrderingNum = clerkOrderingNum;
    }

    public String getUrgent() {
        return urgent;
    }

    public void setUrgent(String urgent) {
        this.urgent = urgent;
    }

    public BigDecimal getStartLongitude() {
        return startLongitude;
    }

    public void setStartLongitude(BigDecimal startLongitude) {
        this.startLongitude = startLongitude;
    }

    public BigDecimal getStartLatitude() {
        return startLatitude;
    }

    public void setStartLatitude(BigDecimal startLatitude) {
        this.startLatitude = startLatitude;
    }

    public BigDecimal getEndLongitude() {
        return endLongitude;
    }

    public void setEndLongitude(BigDecimal endLongitude) {
        this.endLongitude = endLongitude;
    }

    public BigDecimal getEndLatitude() {
        return endLatitude;
    }

    public void setEndLatitude(BigDecimal endLatitude) {
        this.endLatitude = endLatitude;
    }

    public Date getCreateGoodsTime() {
        return createGoodsTime;
    }

    public void setCreateGoodsTime(Date createGoodsTime) {
        this.createGoodsTime = createGoodsTime;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }

    public String getShipperName() {
        return shipperName;
    }

    public void setShipperName(String shipperName) {
        this.shipperName = shipperName;
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

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
