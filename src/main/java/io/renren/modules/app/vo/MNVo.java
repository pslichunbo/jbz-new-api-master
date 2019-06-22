package io.renren.modules.app.vo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 二级分类表
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:21
 */

public class MNVo {
	/**
	 * 
	 */
	private Long id;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 状态 1为可用 0为不可用
	 */
	private Long state;
	/**
	 * 排序
	 */
	private Long sortIndex;
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
	 * 一级分类id
	 */
	private Long menuRootId;
	/**
	 * 用户id
	 */
	private Long userId;

	private String imageUrl;
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

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
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
	 * 设置：名称
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 设置：状态 1为可用 2为不可用
	 */
	public void setState(Long state) {
		this.state = state;
	}
	/**
	 * 获取：状态 1为可用 2为不可用
	 */
	public Long getState() {
		return state;
	}
	/**
	 * 设置：排序
	 */
	public void setSortIndex(Long sortIndex) {
		this.sortIndex = sortIndex;
	}
	/**
	 * 获取：排序
	 */
	public Long getSortIndex() {
		return sortIndex;
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
	 * 设置：一级分类id
	 */
	public void setMenuRootId(Long menuRootId) {
		this.menuRootId = menuRootId;
	}
	/**
	 * 获取：一级分类id
	 */
	public Long getMenuRootId() {
		return menuRootId;
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
