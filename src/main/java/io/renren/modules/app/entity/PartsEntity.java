package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 配件表
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-10-12 14:35:13
 */
@TableName("tb_parts")
public class PartsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
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
	private Long userId;
	/**
	 * 商品品牌id
	 */
	private Long brandId;
	/**
	 * 一级分类ID
	 */
	private Long menuRootId;
	/**
	 * 二级分类ID
	 */
	private Long menuNextId;
	/**
	 * 配件图片
	 */
	private String partsPhoto;

	private String linkMan;

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
	 * 设置：商品品牌id
	 */
	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}
	/**
	 * 获取：商品品牌id
	 */
	public Long getBrandId() {
		return brandId;
	}
	/**
	 * 设置：一级分类ID
	 */
	public void setMenuRootId(Long menuRootId) {
		this.menuRootId = menuRootId;
	}
	/**
	 * 获取：一级分类ID
	 */
	public Long getMenuRootId() {
		return menuRootId;
	}
	/**
	 * 设置：二级分类ID
	 */
	public void setMenuNextId(Long menuNextId) {
		this.menuNextId = menuNextId;
	}
	/**
	 * 获取：二级分类ID
	 */
	public Long getMenuNextId() {
		return menuNextId;
	}
	/**
	 * 设置：配件图片
	 */
	public void setPartsPhoto(String partsPhoto) {
		this.partsPhoto = partsPhoto;
	}
	/**
	 * 获取：配件图片
	 */
	public String getPartsPhoto() {
		return partsPhoto;
	}
}
