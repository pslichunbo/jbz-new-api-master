package io.renren.modules.app.vo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 配件表Vo
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-10-12 14:35:13
 */

public class PartsEntityVo implements Serializable {
	/**
	 * 
	 */
	private Long id;
	/**
	 * 配件名称
	 */
	private String partsName;
	/**
	 * 配件型号
	 */
	private String partsModel;
	/**
	 * 配件价格
	 */
	private BigDecimal partsPrice;
	/**
	 * 所在地
	 */
	private String partsArea;
	private Long areaId;
	private Long proviceId;
	private Long cityId;
	/**
	 * 联系电话
	 */
	private String partsPhone;
	/**
	 * 配件简介
	 */
	private String partsInfo;
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
	private String userName;
	private Long userId;
	/**
	 * 商品品牌id
	 */
	private String brandName;
	private Long brandId;
	/**
	 * 一级分类ID
	 */
	private String menuRootName;
	private Long menuRootId;
	/**
	 * 二级分类ID
	 */
	private String menuNextName;
	private Long menuNextId;
	/**
	 * 配件图片
	 */
	private String[] partsPhoto;

	private String linkMan;

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

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

	public String getLinkMan() {
		return linkMan;
	}

	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
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
	 * 设置：配件名称
	 */
	public void setPartsName(String partsName) {
		this.partsName = partsName;
	}
	/**
	 * 获取：配件名称
	 */
	public String getPartsName() {
		return partsName;
	}
	/**
	 * 设置：配件型号
	 */
	public void setPartsModel(String partsModel) {
		this.partsModel = partsModel;
	}
	/**
	 * 获取：配件型号
	 */
	public String getPartsModel() {
		return partsModel;
	}
	/**
	 * 设置：配件价格
	 */
	public void setPartsPrice(BigDecimal partsPrice) {
		this.partsPrice = partsPrice;
	}
	/**
	 * 获取：配件价格
	 */
	public BigDecimal getPartsPrice() {
		return partsPrice;
	}
	/**
	 * 设置：所在地
	 */
	public void setPartsArea(String partsArea) {
		this.partsArea = partsArea;
	}
	/**
	 * 获取：所在地
	 */
	public String getPartsArea() {
		return partsArea;
	}
	/**
	 * 设置：联系电话
	 */
	public void setPartsPhone(String partsPhone) {
		this.partsPhone = partsPhone;
	}
	/**
	 * 获取：联系电话
	 */
	public String getPartsPhone() {
		return partsPhone;
	}
	/**
	 * 设置：配件简介
	 */
	public void setPartsInfo(String partsInfo) {
		this.partsInfo = partsInfo;
	}
	/**
	 * 获取：配件简介
	 */
	public String getPartsInfo() {
		return partsInfo;
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
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
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

	/**
	 * 设置：配件图片
	 */
	public void setPartsPhoto(String[] partsPhoto) {
		this.partsPhoto = partsPhoto;
	}
	/**
	 * 获取：配件图片
	 */
	public String[] getPartsPhoto() {
		return partsPhoto;
	}
}
