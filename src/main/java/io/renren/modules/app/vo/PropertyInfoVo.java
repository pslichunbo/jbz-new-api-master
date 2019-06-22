package io.renren.modules.app.vo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 二级属性Vo
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:21
 */

public class PropertyInfoVo {

	/**
	 * 
	 */
	private Long id;
	/**
	 * 属性详情名称
	 */
	private String name;
	/**
	 * 状态 1可用 0不可用
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
	 * 一级属性id
	 */
	private String propertyName;
	/**
	 * 用户id
	 */
	private String userName;

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
	 * 设置：属性详情名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：属性详情名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：状态 1可用 0不可用
	 */
	public void setState(Long state) {
		this.state = state;
	}
	/**
	 * 获取：状态 1可用 0不可用
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


	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
