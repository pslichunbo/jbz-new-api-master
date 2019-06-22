package io.renren.modules.app.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ApiSourceVo {
    private Long id;
    /**
     * 出发地省
     */
    private String startProvince;
    /**
     * 出发地市
     */
    private String startCity;
    /**
     * 出发地县
     */
    private String startCounty;
    /**
     * 目的地省
     */
    private String endProvince;
    /**
     * 目的地市
     */
    private String endCity;
    /**
     * 目的地县
     */
    private String endCounty;
    /**
     * 出发地详细地址
     */
    private String startPointAddr;
    private String endAddress;

    private String startAddress;

    private String endPointAddr;

    /**
     * 货源描述
     */
    private String cargoDescription;
    /**
     * 寄件人电话号码
     */
    private String tel;
    /**
     * 寄件人姓名
     */
    private String linkName;
    /**
     * 货源状态 0已发布 1有申请 2指派中 3取货中 4运输中 5已送达 6已完成 7异常
     */
    private Long state;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date alterTime;
    /**
     * 发布人id
     */
    private Long userId;
    /**
     * 是否加急 0：普通 1：加急
     */
    private String urgent;
    /**
     * 估重
     */
    private Double weight;


    private int clerkOrderingNum;

    private BigDecimal startLongitude;
    private BigDecimal startLatitude;
    private BigDecimal endLongitude;
    private BigDecimal endLatitude;
    private String[] images;
    private String goodsNumber;
    private Date orderTime;
    private Date arriveTime;
    private List<UserVo> voList;
    private String shipperName;
    private String orderId;
    private String driverPhone;

    public String getDriverPhone() {
        return driverPhone;
    }

    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getShipperName() {
        return shipperName;
    }

    public void setShipperName(String shipperName) {
        this.shipperName = shipperName;
    }

    public List<UserVo> getVoList() {
        return voList;
    }

    public void setVoList(List<UserVo> voList) {
        this.voList = voList;
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

    public String getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(String goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartProvince() {
        return startProvince;
    }

    public void setStartProvince(String startProvince) {
        this.startProvince = startProvince;
    }

    public String getStartCity() {
        return startCity;
    }

    public void setStartCity(String startCity) {
        this.startCity = startCity;
    }

    public String getStartCounty() {
        return startCounty;
    }

    public void setStartCounty(String startCounty) {
        this.startCounty = startCounty;
    }

    public String getEndProvince() {
        return endProvince;
    }

    public void setEndProvince(String endProvince) {
        this.endProvince = endProvince;
    }

    public String getEndCity() {
        return endCity;
    }

    public void setEndCity(String endCity) {
        this.endCity = endCity;
    }

    public String getEndCounty() {
        return endCounty;
    }

    public void setEndCounty(String endCounty) {
        this.endCounty = endCounty;
    }

    public String getStartPointAddr() {
        return startPointAddr;
    }

    public void setStartPointAddr(String startPointAddr) {
        this.startPointAddr = startPointAddr;
    }

    public String getEndAddress() {
        return endAddress;
    }

    public void setEndAddress(String endAddress) {
        this.endAddress = endAddress;
    }

    public String getStartAddress() {
        return startAddress;
    }

    public void setStartAddress(String startAddress) {
        this.startAddress = startAddress;
    }

    public String getEndPointAddr() {
        return endPointAddr;
    }

    public void setEndPointAddr(String endPointAddr) {
        this.endPointAddr = endPointAddr;
    }

    public String getCargoDescription() {
        return cargoDescription;
    }

    public void setCargoDescription(String cargoDescription) {
        this.cargoDescription = cargoDescription;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public Long getState() {
        return state;
    }

    public void setState(Long state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getAlterTime() {
        return alterTime;
    }

    public void setAlterTime(Date alterTime) {
        this.alterTime = alterTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUrgent() {
        return urgent;
    }

    public void setUrgent(String urgent) {
        this.urgent = urgent;
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

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }
}
