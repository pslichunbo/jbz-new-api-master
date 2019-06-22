package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 消息表
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-10-17 14:35:24
 */
@TableName("tb_message")
public class MessageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 消息标题
	 */
	private String title;
	/**
	 * 消息内容
	 */
	private String content;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改时间
	 */
	private Date alterIme;
	/**
	 * 删除时间
	 */
	private Date deleteTime;
	/**
	 * 删除标识 1删除 0未删除
	 */
	private Long delSign;
	/**
	 * 类型id(0:系统消息，1：我的订单 2：我的货源)
	 */
	private Long typeId;
	/**
	 * 消息已读/未读标识符 1已读 0未读
	 */
	private Long readSign;
	/**
	 * 推送分类标签
	 */
	private String tag;
	/**
	 * 用户id
	 */
	private Long userId;

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
	 * 设置：消息标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：消息标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：消息内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：消息内容
	 */
	public String getContent() {
		return content;
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
	public void setAlterIme(Date alterIme) {
		this.alterIme = alterIme;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getAlterIme() {
		return alterIme;
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
	 * 设置：删除标识 1删除 0未删除
	 */
	public void setDelSign(Long delSign) {
		this.delSign = delSign;
	}
	/**
	 * 获取：删除标识 1删除 0未删除
	 */
	public Long getDelSign() {
		return delSign;
	}
	/**
	 * 设置：类型id(0:系统消息，1：我的订单 2：我的货源)
	 */
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
	/**
	 * 获取：类型id(0:系统消息，1：我的订单 2：我的货源)
	 */
	public Long getTypeId() {
		return typeId;
	}
	/**
	 * 设置：消息已读/未读标识符 1已读 0未读
	 */
	public void setReadSign(Long readSign) {
		this.readSign = readSign;
	}
	/**
	 * 获取：消息已读/未读标识符 1已读 0未读
	 */
	public Long getReadSign() {
		return readSign;
	}
	/**
	 * 设置：推送分类标签
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}
	/**
	 * 获取：推送分类标签
	 */
	public String getTag() {
		return tag;
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
