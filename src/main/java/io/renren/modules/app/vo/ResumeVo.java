package io.renren.modules.app.vo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-31 09:20:03
 */
public class ResumeVo {

	/**
	 * ID
	 */
	private Long id;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 头像
	 */
	private String portrait;
	/**
	 * 个人描述
	 */
	private String describe;
	/**
	 * 联系电话
	 */
	private String phone;
	/**
	 * 性别 0男生 1 女生
	 */
	private Long sex;
	/**
	 * 居住地区
	 */
	private String address;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 工作职位
	 */
	private String position;
	/**
	 * 待遇
	 */
	private String treatment;
	/**
	 * 联系人
	 */
	private String linkMan;
	/**
	 * 联系电话
	 */
	private String linkNumber;
	/**
	 * 工作地点
	 */
	private String workAddress;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 类型
	 */
	private String typeName;
	/**
	 * 0为招聘  1 为求职
	 */
	private Long status;

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
	 * 设置：头像
	 */
	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}
	/**
	 * 获取：头像
	 */
	public String getPortrait() {
		return portrait;
	}
	/**
	 * 设置：个人描述
	 */
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	/**
	 * 获取：个人描述
	 */
	public String getDescribe() {
		return describe;
	}
	/**
	 * 设置：联系电话
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：联系电话
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：性别 0男生 1 女生
	 */
	public void setSex(Long sex) {
		this.sex = sex;
	}
	/**
	 * 获取：性别 0男生 1 女生
	 */
	public Long getSex() {
		return sex;
	}
	/**
	 * 设置：居住地区
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：居住地区
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：工作职位
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	/**
	 * 获取：工作职位
	 */
	public String getPosition() {
		return position;
	}
	/**
	 * 设置：待遇
	 */
	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}
	/**
	 * 获取：待遇
	 */
	public String getTreatment() {
		return treatment;
	}
	/**
	 * 设置：联系人
	 */
	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}
	/**
	 * 获取：联系人
	 */
	public String getLinkMan() {
		return linkMan;
	}
	/**
	 * 设置：联系电话
	 */
	public void setLinkNumber(String linkNumber) {
		this.linkNumber = linkNumber;
	}
	/**
	 * 获取：联系电话
	 */
	public String getLinkNumber() {
		return linkNumber;
	}
	/**
	 * 设置：工作地点
	 */
	public void setWorkAddress(String workAddress) {
		this.workAddress = workAddress;
	}
	/**
	 * 获取：工作地点
	 */
	public String getWorkAddress() {
		return workAddress;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：类型
	 */
	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	/**
	 * 设置：0为招聘  1 为求职
	 */
	public void setStatus(Long status) {
		this.status = status;
	}
	/**
	 * 获取：0为招聘  1 为求职
	 */
	public Long getStatus() {
		return status;
	}
}
