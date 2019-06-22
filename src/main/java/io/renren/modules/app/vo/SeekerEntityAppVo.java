package io.renren.modules.app.vo;

import java.util.Date;

/**
 * 求职者简历----找帮手
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-09-04 10:10:55
 */

public class SeekerEntityAppVo {


	/**
	 * 
	 */
	private Long id;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 生日
	 */
	private String birthday;
	/**
	 * 住址
	 */
	private String areaName;
	/**
	 * 职位
	 */
	private String job;
	/**
	 * 工作经验
	 */
	private String experience;
	/**
	 * 薪资
	 */
	private String salary;
	/**
	 * 证书、照片
	 */
	private String photo;
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
	private String Phone;
	private String portrait;
	private String specialty;

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public String getPortrait() {
		return portrait;
	}

	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}



	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
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
	 * 设置：生日
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	/**
	 * 获取：生日
	 */
	public String getBirthday() {
		return birthday;
	}
	/**
	 * 设置：住址
	 */

	/**
	 * 设置：职位
	 */
	public void setJob(String job) {
		this.job = job;
	}
	/**
	 * 获取：职位
	 */
	public String getJob() {
		return job;
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
	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}
/**
	 * 设置：证书、照片
	 */

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

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
}
