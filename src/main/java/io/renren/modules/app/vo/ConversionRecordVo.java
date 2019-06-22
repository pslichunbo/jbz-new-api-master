package io.renren.modules.app.vo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 兑换记录Vo表
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:21
 */
@TableName("tb_conversion_record")
public class ConversionRecordVo implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private Long id;
	/**
	 * 礼品id
	 */
	private String presentName;
	/**
	 * 1兑换完成0兑换未完成
	 */
	private Long status;
	/**
	 * 用户id
	 */
	private Long userId;
	/**
	 * 1删除 0未删除
	 */
	private Long dellSign;
	/**
	 * 用户姓名
	 */
	private String userName;
	/**
	 * 用户电话
	 */
	private String userTel;
	/**
	 * 邮编
	 */
	private String postCode;
	/**
	 * 地址
	 */
	private String address;
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
	private Date deleteTtime;
	private String typeName;


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
	 * 设置：1兑换完成0兑换未完成
	 */
	public void setStatus(Long status) {
		this.status = status;
	}
	/**
	 * 获取：1兑换完成0兑换未完成
	 */
	public Long getStatus() {
		return status;
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
	 * 设置：1删除 0未删除
	 */
	public void setDellSign(Long dellSign) {
		this.dellSign = dellSign;
	}
	/**
	 * 获取：1删除 0未删除
	 */
	public Long getDellSign() {
		return dellSign;
	}
	/**
	 * 设置：用户姓名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：用户姓名
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置：用户电话
	 */
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	/**
	 * 获取：用户电话
	 */
	public String getUserTel() {
		return userTel;
	}
	/**
	 * 设置：邮编
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	/**
	 * 获取：邮编
	 */
	public String getPostCode() {
		return postCode;
	}
	/**
	 * 设置：地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：地址
	 */
	public String getAddress() {
		return address;
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
	public void setDeleteTtime(Date deleteTtime) {
		this.deleteTtime = deleteTtime;
	}
	/**
	 * 获取：删除时间
	 */
	public Date getDeleteTtime() {
		return deleteTtime;
	}

	public String getPresentName() {
		return presentName;
	}

	public void setPresentName(String presentName) {
		this.presentName = presentName;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
}
