package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 维修店
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:22
 */
@TableName("tb_maintenance_store")
public class MaintenanceStoreEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 门店名字
	 */
	private String storeName;
	/**
	 * 门店简介
	 */
	private String storeInfo;
	/**
	 * 经营范围
	 */
	private String businessScope;
	/**
	 * 门店地址
	 */
	private String areaId;
	/**
	 * 详细地址
	 */
	private String address;
	/**
	 * 店长名字
	 */
	private String shopManagerName;
	/**
	 * 店长电话
	 */
	private String shopManagerPhone;
	/**
	 * 门面照片
	 */
	private String storeImage;
	/**
	 * 门店秀
	 */
	private String storeBeautifulImage;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改时间
	 */
	private Date alterTime;
	/**
	 * 删除时间
	 */
	private Date deleteTime;
	/**
	 * 用户id
	 */
	private Long userId;

	private Long typeId;

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
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
	 * 设置：门店名字
	 */
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	/**
	 * 获取：门店名字
	 */
	public String getStoreName() {
		return storeName;
	}
	/**
	 * 设置：门店简介
	 */
	public void setStoreInfo(String storeInfo) {
		this.storeInfo = storeInfo;
	}
	/**
	 * 获取：门店简介
	 */
	public String getStoreInfo() {
		return storeInfo;
	}
	/**
	 * 设置：经营范围
	 */
	public void setBusinessScope(String businessScope) {
		this.businessScope = businessScope;
	}
	/**
	 * 获取：经营范围
	 */
	public String getBusinessScope() {
		return businessScope;
	}
	/**
	 * 设置：门店地址
	 */
	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	/**
	 * 设置：详细地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：详细地址
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：店长名字
	 */
	public void setShopManagerName(String shopManagerName) {
		this.shopManagerName = shopManagerName;
	}
	/**
	 * 获取：店长名字
	 */
	public String getShopManagerName() {
		return shopManagerName;
	}
	/**
	 * 设置：店长电话
	 */
	public void setShopManagerPhone(String shopManagerPhone) {
		this.shopManagerPhone = shopManagerPhone;
	}
	/**
	 * 获取：店长电话
	 */
	public String getShopManagerPhone() {
		return shopManagerPhone;
	}
	/**
	 * 设置：门面照片
	 */
	public void setStoreImage(String storeImage) {
		this.storeImage = storeImage;
	}
	/**
	 * 获取：门面照片
	 */
	public String getStoreImage() {
		return storeImage;
	}
	/**
	 * 设置：门店秀
	 */
	public void setStoreBeautifulImage(String storeBeautifulImage) {
		this.storeBeautifulImage = storeBeautifulImage;
	}
	/**
	 * 获取：门店秀
	 */
	public String getStoreBeautifulImage() {
		return storeBeautifulImage;
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
	 * 设置：删除时间
	 */
	public void setDeleteTime(Date deleteTime) {
		this.deleteTime = deleteTime;
	}
	/**
	 * 获取：删除时间
	 */
	public Date getDeleteTime() {
		return deleteTime;
	}
	/**
	 * 设置：用户id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户id
	 */
	public Long getUserId() {
		return userId;
	}
}
