package io.renren.modules.app.vo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 新机表Vo
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-10-12 14:35:13
 */
public class MachineEntityVo implements Serializable {
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
	 * 品牌id
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
	private List<propertyAdmin> propertyId;
	private String property;

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

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
	 * 价格
	 */
	private BigDecimal price;
	/**
	 * 联系电话
	 */
	private String linkPhone;

	private String workingLife;

	private String tonnage;

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String[] getImage() {
		return image;
	}

	public void setImage(String[] image) {
		this.image = image;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
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

	public Date getDeleteTime() {
		return deleteTime;
	}

	public void setDeleteTime(Date deleteTime) {
		this.deleteTime = deleteTime;
	}

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

	public List<propertyAdmin> getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(List<propertyAdmin> propertyId) {
		this.propertyId = propertyId;
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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getLinkPhone() {
		return linkPhone;
	}

	public void setLinkPhone(String linkPhone) {
		this.linkPhone = linkPhone;
	}
}
