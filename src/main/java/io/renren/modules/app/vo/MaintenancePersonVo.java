package io.renren.modules.app.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 维修人
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:22
 */
public class MaintenancePersonVo{
	public String address;
	public String addressInf;
	public String headPortrait;
	public Long id;
	public String name;
	public String phone;
	public String skill;
	public List<String> skillScope;
	public Long userId;
	public List<String> workPortrait;
	public String typeName;
	public Long sex;

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Long getSex() {
		return sex;
	}

	public void setSex(Long sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressInf() {
		return addressInf;
	}

	public void setAddressInf(String addressInf) {
		this.addressInf = addressInf;
	}

	public String getHeadPortrait() {
		return headPortrait;
	}

	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public List<String> getSkillScope() {
		return skillScope;
	}

	public void setSkillScope(List<String> skillScope) {
		this.skillScope = skillScope;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public List<String> getWorkPortrait() {
		return workPortrait;
	}

	public void setWorkPortrait(List<String> workPortrait) {
		this.workPortrait = workPortrait;
	}
}
