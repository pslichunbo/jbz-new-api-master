package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 二手机械表
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-10-12 14:35:13
 */
@TableName("tb_old_machine")
public class OldMachineEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 机械标题
	 */
	private String title;
	/**
	 * 新机图片地址
	 */
	private String image;
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
	 * 品牌id
	 */
	private Long brandId;
	/**
	 * 用户id
	 */
	private Long userId;
	/**
	 * 属性id
	 */
	private String propertyId;
	/**
	 * 一级列表id
	 */
	private Long menuRootId;
	/**
	 * 二级列表id
	 */
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
	private Long areaId;
	/**
	 * 联系人
	 */
	private String linkMan;

	private String tonnage;
	private Long useDay;

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
	public void setImage(String image) {
		this.image = image;
	}
	/**
	 * 获取：新机图片地址
	 */
	public String getImage() {
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
	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}
	/**
	 * 获取：品牌id
	 */
	public Long getBrandId() {
		return brandId;
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
	/**
	 * 设置：属性id
	 */
	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}
	/**
	 * 获取：属性id
	 */
	public String getPropertyId() {
		return propertyId;
	}
	/**
	 * 设置：一级列表id
	 */
	public void setMenuRootId(Long menuRootId) {
		this.menuRootId = menuRootId;
	}
	/**
	 * 获取：一级列表id
	 */
	public Long getMenuRootId() {
		return menuRootId;
	}
	/**
	 * 设置：二级列表id
	 */
	public void setMenuNextId(Long menuNextId) {
		this.menuNextId = menuNextId;
	}
	/**
	 * 获取：二级列表id
	 */
	public Long getMenuNextId() {
		return menuNextId;
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
	 * 设置：所在地区
	 */
	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}
	/**
	 * 获取：所在地区
	 */
	public Long getAreaId() {
		return areaId;
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
