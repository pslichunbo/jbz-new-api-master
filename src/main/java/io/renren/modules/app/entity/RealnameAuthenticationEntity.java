package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 实名认证表
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-09-29 15:27:28
 */
@TableName("tb_realname_authentication")
public class RealnameAuthenticationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 身份证号
	 */
	private String idNumber;
	/**
	 * 身份证正面
	 */
	private String idNumberFront;
	/**
	 * 身份证反面
	 */
	private String idNumberContrary;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改时间
	 */
	private Date alterTime;
	/**
	 * 审核状态 0 证件审核中 1证件审核通过 2证件审核未通过
	 */
	private String status;
	private Long userId;
	private String phone;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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
	 * 设置：姓名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：姓名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：身份证号
	 */
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	/**
	 * 获取：身份证号
	 */
	public String getIdNumber() {
		return idNumber;
	}
	/**
	 * 设置：身份证正面
	 */
	public void setIdNumberFront(String idNumberFront) {
		this.idNumberFront = idNumberFront;
	}
	/**
	 * 获取：身份证正面
	 */
	public String getIdNumberFront() {
		return idNumberFront;
	}
	/**
	 * 设置：身份证反面
	 */
	public void setIdNumberContrary(String idNumberContrary) {
		this.idNumberContrary = idNumberContrary;
	}
	/**
	 * 获取：身份证反面
	 */
	public String getIdNumberContrary() {
		return idNumberContrary;
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
	 * 设置：审核状态 0 证件审核中 1证件审核通过 2证件审核未通过
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：审核状态 0 证件审核中 1证件审核通过 2证件审核未通过
	 */
	public String getStatus() {
		return status;
	}
}
