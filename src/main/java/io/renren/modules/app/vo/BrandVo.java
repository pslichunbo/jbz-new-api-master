package io.renren.modules.app.vo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品品牌表
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:22
 */

public class BrandVo {


	/**
	 * 
	 */

	private Long id;
	/**
	 * 品牌名称
	 */
	private String name;
	/**
	 * 品牌logo
	 */
	private String brandLogo;
	/**
	 * 品牌简介
	 */
	private String brandInfo;
	/**
	 * 类型id
	 */
	private Long typeId;
	/**
	 * 1 可用 0不可用
	 */
	private Long status;
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
	private Long menuNextId;
	private Long userId;
	private String pname;
	private String tag;

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getMenuNextId() {
		return menuNextId;
	}

	public void setMenuNextId(Long menuNextId) {
		this.menuNextId = menuNextId;
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
	 * 设置：品牌名称
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 设置：品牌logo
	 */
	public void setBrandLogo(String brandLogo) {
		this.brandLogo = brandLogo;
	}
	/**
	 * 获取：品牌logo
	 */
	public String getBrandLogo() {
		return brandLogo;
	}
	/**
	 * 设置：品牌简介
	 */
	public void setBrandInfo(String brandInfo) {
		this.brandInfo = brandInfo;
	}
	/**
	 * 获取：品牌简介
	 */
	public String getBrandInfo() {
		return brandInfo;
	}
	/**
	 * 设置：类型id
	 */
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
	/**
	 * 获取：类型id
	 */
	public Long getTypeId() {
		return typeId;
	}
	/**
	 * 设置：1 可用 0不可用
	 */
	public void setStatus(Long status) {
		this.status = status;
	}
	/**
	 * 获取：1 可用 0不可用
	 */
	public Long getStatus() {
		return status;
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
}
