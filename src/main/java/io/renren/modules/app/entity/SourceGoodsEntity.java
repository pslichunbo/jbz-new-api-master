package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 货源表
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-09-29 16:18:27
 */
@TableName("tb_source_goods")
public class SourceGoodsEntity implements Serializable {
	private static final long serialVersionUID = 1L;




	/**
	 * 
	 */
	@TableId
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

	/**
	 * 目的地详细地址
	 */


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
	//出发地经度
	private BigDecimal startLongitude;
	//出发地纬度
	private BigDecimal startLatitude;
	//目的地经度
	private BigDecimal endLongitude;
	//目的地纬度
	private BigDecimal endLatitude;
	private String images;
	private String goodsNumber;

	public String getGoodsNumber() {
		return goodsNumber;
	}

	public void setGoodsNumber(String goodsNumber) {
		this.goodsNumber = goodsNumber;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
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

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：出发地省
	 */
	public void setStartProvince(String startProvince) {
		this.startProvince = startProvince;
	}
	/**
	 * 获取：出发地省
	 */
	public String getStartProvince() {
		return startProvince;
	}
	/**
	 * 设置：出发地市
	 */
	public void setStartCity(String startCity) {
		this.startCity = startCity;
	}
	/**
	 * 获取：出发地市
	 */
	public String getStartCity() {
		return startCity;
	}
	/**
	 * 设置：出发地县
	 */
	public void setStartCounty(String startCounty) {
		this.startCounty = startCounty;
	}
	/**
	 * 获取：出发地县
	 */
	public String getStartCounty() {
		return startCounty;
	}
	/**
	 * 设置：目的地省
	 */
	public void setEndProvince(String endProvince) {
		this.endProvince = endProvince;
	}
	/**
	 * 获取：目的地省
	 */
	public String getEndProvince() {
		return endProvince;
	}
	/**
	 * 设置：目的地市
	 */
	public void setEndCity(String endCity) {
		this.endCity = endCity;
	}
	/**
	 * 获取：目的地市
	 */
	public String getEndCity() {
		return endCity;
	}
	/**
	 * 设置：目的地县
	 */
	public void setEndCounty(String endCounty) {
		this.endCounty = endCounty;
	}
	/**
	 * 获取：目的地县
	 */
	public String getEndCounty() {
		return endCounty;
	}
	/**
	 * 设置：出发地详细地址
	 */
	public void setStartPointAddr(String startPointAddr) {
		this.startPointAddr = startPointAddr;
	}
	/**
	 * 获取：出发地详细地址
	 */
	public String getStartPointAddr() {
		return startPointAddr;
	}
	/**
	 * 设置：目的地详细地址
	 */
	public void setEndPointAddr(String endPointAddr) {
		this.endPointAddr = endPointAddr;
	}
	/**
	 * 获取：目的地详细地址
	 */
	public String getEndPointAddr() {
		return endPointAddr;
	}
	/**
	 * 设置：货源描述
	 */
	public void setCargoDescription(String cargoDescription) {
		this.cargoDescription = cargoDescription;
	}
	/**
	 * 获取：货源描述
	 */
	public String getCargoDescription() {
		return cargoDescription;
	}
	/**
	 * 设置：寄件人电话号码
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	/**
	 * 获取：寄件人电话号码
	 */
	public String getTel() {
		return tel;
	}
	/**
	 * 设置：寄件人姓名
	 */
	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}
	/**
	 * 获取：寄件人姓名
	 */
	public String getLinkName() {
		return linkName;
	}
	/**
	 * 设置：货源状态 0已发布 1有申请 2指派中 3取货中 4运输中 5已送达 6已完成 7异常
	 */
	public void setState(Long state) {
		this.state = state;
	}
	/**
	 * 获取：货源状态 0已发布 1有申请 2指派中 3取货中 4运输中 5已送达 6已完成 7异常
	 */
	public Long getState() {
		return state;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：修改时间
	 */
	public void setAlterTime(Date alterTime) {
		this.alterTime = alterTime;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getAlterTime() {
		return alterTime;
	}
	/**
	 * 设置：发布人id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：发布人id
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：是否加急 0：普通 1：加急
	 */
	public void setUrgent(String urgent) {
		this.urgent = urgent;
	}
	/**
	 * 获取：是否加急 0：普通 1：加急
	 */
	public String getUrgent() {
		return urgent;
	}
	/**
	 * 设置：估重
	 */
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	/**
	 * 获取：估重
	 */
	public Double getWeight() {
		return weight;
	}

	public int getClerkOrderingNum() {
		return clerkOrderingNum;
	}

	public void setClerkOrderingNum(int clerkOrderingNum) {
		this.clerkOrderingNum = clerkOrderingNum;
	}
}
