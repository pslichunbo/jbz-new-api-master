package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 金币记录表
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:22
 */
@TableName("tb_gold_record")
public class GoldRecordEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 金币数量
	 */
	private Long goldAmount;
	/**
	 * 金币变动原因
	 */
	private String changeCause;
	/**
	 * 类型id
	 */
	private Long typeId;
	/**
	 * 用户id
	 */
	private Long userId;
	/**
	 * 礼品id
	 */
	private Long rellId;
	/**
	 * 1删除 0未删除
	 */
	private Long delSign;
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
	 * 设置：金币数量
	 */
	public void setGoldAmount(Long goldAmount) {
		this.goldAmount = goldAmount;
	}
	/**
	 * 获取：金币数量
	 */
	public Long getGoldAmount() {
		return goldAmount;
	}
	/**
	 * 设置：金币变动原因
	 */
	public void setChangeCause(String changeCause) {
		this.changeCause = changeCause;
	}
	/**
	 * 获取：金币变动原因
	 */
	public String getChangeCause() {
		return changeCause;
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
	 * 设置：礼品id
	 */
	public void setRellId(Long rellId) {
		this.rellId = rellId;
	}
	/**
	 * 获取：礼品id
	 */
	public Long getRellId() {
		return rellId;
	}
	/**
	 * 设置：1删除 0未删除
	 */
	public void setDelSign(Long delSign) {
		this.delSign = delSign;
	}
	/**
	 * 获取：1删除 0未删除
	 */
	public Long getDelSign() {
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
}
