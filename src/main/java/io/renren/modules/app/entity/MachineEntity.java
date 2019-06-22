package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 新机表
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-10-12 14:35:13
 */
@TableName("tb_machine")
public class MachineEntity implements Serializable {
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
	 * 价格
	 */
	private BigDecimal price;
	/**
	 * 联系电话
	 */
	private String linkPhone;
	private String workingLife;
	private String tonnage;

	public String getWorkingLife() {
		return workingLife;
	}

	public void setWorkingLife(String workingLife) {
		this.workingLife = workingLife;
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
	 * 设置：价格
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * 获取：价格
	 */
	public BigDecimal getPrice() {
		return price;
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
}
