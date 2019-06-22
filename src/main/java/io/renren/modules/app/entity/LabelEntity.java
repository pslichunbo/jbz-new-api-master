package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 标签表
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:22
 */
@TableName("tb_label")
public class LabelEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 标签名字
	 */
	private String name;
	/**
	 * 标签描述
	 */
	private String description;
	/**
	 * 类型id
	 */
	private Long typeId;
	/**
	 * 1删除 0未删除
	 */
	private String delSign;
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
	 * 1可用 0不可用
	 */
	private String state;
	/**
	 * 排序
	 */
	private Long sortIndex;
	private Long merchantId;

	public Long getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
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
	 * 设置：标签名字
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：标签名字
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：标签描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 获取：标签描述
	 */
	public String getDescription() {
		return description;
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
	 * 设置：1删除 0未删除
	 */
	public void setDelSign(String delSign) {
		this.delSign = delSign;
	}
	/**
	 * 获取：1删除 0未删除
	 */
	public String getDelSign() {
		return delSign;
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
	 * 设置：1可用 0不可用
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * 获取：1可用 0不可用
	 */
	public String getState() {
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
}
