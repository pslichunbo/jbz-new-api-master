package io.renren.modules.app.vo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-09-03 13:50:15
 */
public class EntrustEntityVo{

	/**
	 * ID
	 */
	private Long id;
	/**
	 * 要求
	 */
	private String requirement;
	/**
	 * 联系方式
	 */
	private String linkPhone;
	/**
	 * 用户id
	 */
	private String userName;

	/**
	 * 设置：ID
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：ID
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：要求
	 */
	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}
	/**
	 * 获取：要求
	 */
	public String getRequirement() {
		return requirement;
	}
	/**
	 * 设置：联系方式
	 */
	public void setLinkPhone(String linkPhone) {
		this.linkPhone = linkPhone;
	}
	/**
	 * 获取：联系方式
	 */
	public String getLinkPhone() {
		return linkPhone;
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
}
