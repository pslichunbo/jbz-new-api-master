package io.renren.modules.app.vo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 二手机械表Vo
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-10-12 14:35:13
 */
public class OldMachineEntityVo implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private Long id;
	/**
	 * 机械标题
	 */
	private String title;
	/**
	 * 新机图片地址
	 */
	private String[] image;
	/**
	 * 描述
	 */
	private String info;
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
	 * 品牌
	 */
	private String brandName;
	private Long brandId;
	/**
	 * 用户id
	 */
	private String userName;
	private Long userId;
	/**
	 * 属性id
	 */
	private String property;
	private List<propertyAdmin> propertyId;
	/**
	 * 一级列表id
	 */
	private String menuRootName;
	private Long menuRootId;
	/**
	 * 二级列表id
	 */
	private String menuNextName;
	private Long menuNextId;
	/**
	 * 联系电话
	 */
	private String linkPhone;
	/**
	 * 设备型号
	 */
	private String model;
	/**
	 * 设备报价
	 */
	private BigDecimal price;
	/**
	 * 出厂时间
	 */
	private String deliveryTime;
	/**
	 * 使用天数
	 */
	private String workingLife;
	/**
	 * 所在地区
	 */
	private String areaName;
	private Long areaId;
	private Long proviceId;
	private Long cityId;

	/**
	 * 联系人
	 */
	private String linkMan;

	private String tonnage;
	private Long useDay;

	public Long getProviceId() {
		return proviceId;
	}

	public void setProviceId(Long proviceId) {
		this.proviceId = proviceId;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public List<propertyAdmin> getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(List<propertyAdmin> propertyId) {
		this.propertyId = propertyId;
	}

	public Long getMenuRootId() {
		return menuRootId;
	}

	public void setMenuRootId(Long menuRootId) {
		this.menuRootId = menuRootId;
	}

	public Long getMenuNextId() {
		return menuNextId;
	}

	public void setMenuNextId(Long menuNextId) {
		this.menuNextId = menuNextId;
	}

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public Long getUseDay() {
		return useDay;
	}

	public void setUseDay(Long useDay) {
		this.useDay = useDay;
	}

	public String getTonnage() {
		return tonnage;
	}

	public void setTonnage(String tonnage) {
		this.tonnage = tonnage;
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
	 * 设置：机械标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：机械标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：新机图片地址
	 */
	public void setImage(String[] image) {
		this.image = image;
	}
	/**
	 * 获取：新机图片地址
	 */
	public String[] getImage() {
		return image;
	}
	/**
	 * 设置：描述
	 */
	public void setInfo(String info) {
		this.info = info;
	}
	/**
	 * 获取：描述
	 */
	public String getInfo() {
		return info;
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
	 * 设置：品牌id
	 */
	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getMenuRootName() {
		return menuRootName;
	}

	public void setMenuRootName(String menuRootName) {
		this.menuRootName = menuRootName;
	}

	public String getMenuNextName() {
		return menuNextName;
	}

	public void setMenuNextName(String menuNextName) {
		this.menuNextName = menuNextName;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	/**
	 * 设置：联系电话
	 */
	public void setLinkPhone(String linkPhone) {
		this.linkPhone = linkPhone;
	}
	/**
	 * 获取：联系电话
	 */
	public String getLinkPhone() {
		return linkPhone;
	}
	/**
	 * 设置：设备型号
	 */
	public void setModel(String model) {
		this.model = model;
	}
	/**
	 * 获取：设备型号
	 */
	public String getModel() {
		return model;
	}
	/**
	 * 设置：设备报价
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * 获取：设备报价
	 */
	public BigDecimal getPrice() {
		return price;
	}
	/**
	 * 设置：出厂时间
	 */
	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	/**
	 * 获取：出厂时间
	 */
	public String getDeliveryTime() {
		return deliveryTime;
	}
	/**
	 * 设置：使用天数
	 */
	public void setWorkingLife(String workingLife) {
		this.workingLife = workingLife;
	}
	/**
	 * 获取：使用天数
	 */
	public String getWorkingLife() {
		return workingLife;
	}
	/**
	 * 设置：联系人
	 */
	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}
	/**
	 * 获取：联系人
	 */
	public String getLinkMan() {
		return linkMan;
	}
}
