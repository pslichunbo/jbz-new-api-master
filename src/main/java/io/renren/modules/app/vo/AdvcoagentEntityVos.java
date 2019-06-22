package io.renren.modules.app.vo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 发布招聘-----找帮手Vo
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-09-04 10:10:54
 */

public class AdvcoagentEntityVos implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 职位
	 */
	private Long jobId;
	/**
	 * 工作经验
	 */
	private String experience;
	/**
	 * 薪资
	 */
	private String salary;
	/**
	 * 工作性质：全职 兼职
	 */
	private String property;
	/**
	 * 招聘人数
	 */
	private Integer advertiseNumber;
	/**
	 * 年龄要求
	 */
	private String ageGroup;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 描述
	 */
	private String depict;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改时间
	 */
	private Date alterTime;
	private String title;
	private String areaName ;
	private String address;
	private String company;
	private String principal;
	private String phone;
	private String remark;
	private Long userId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	/**
	 * 设置：
	 */

	/**
	 * 设置：职位
	 */
	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	/**
	 * 设置：工作经验
	 */
	public void setExperience(String experience) {
		this.experience = experience;
	}
	/**
	 * 获取：工作经验
	 */
	public String getExperience() {
		return experience;
	}
	/**
	 * 设置：薪资
	 */
	public void setSalary(String salary) {
		this.salary = salary;
	}
	/**
	 * 获取：薪资
	 */
	public String getSalary() {
		return salary;
	}
	/**
	 * 设置：工作性质：全职 兼职
	 */
	public void setProperty(String property) {
		this.property = property;
	}
	/**
	 * 获取：工作性质：全职 兼职
	 */
	public String getProperty() {
		return property;
	}
	/**
	 * 设置：招聘人数
	 */
	public void setAdvertiseNumber(Integer advertiseNumber) {
		this.advertiseNumber = advertiseNumber;
	}
	/**
	 * 获取：招聘人数
	 */
	public Integer getAdvertiseNumber() {
		return advertiseNumber;
	}
	/**
	 * 设置：年龄要求
	 */
	public void setAgeGroup(String ageGroup) {
		this.ageGroup = ageGroup;
	}
	/**
	 * 获取：年龄要求
	 */
	public String getAgeGroup() {
		return ageGroup;
	}
	/**
	 * 设置：性别
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * 获取：性别
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * 设置：描述
	 */
	public void setDepict(String depict) {
		this.depict = depict;
	}
	/**
	 * 获取：描述
	 */
	public String getDepict() {
		return depict;
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
}
