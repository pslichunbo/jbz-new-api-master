package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 维修人
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:22
 */
@TableName("tb_maintenance_person")
public class MaintenancePersonEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 维修人名字
	 */
	private String name;
	/**
	 * 维修人擅长技能
	 */


	/**
	 * 技能服务范围
	 */
	private String skillScope;
	/**
	 * 维修人电话号码
	 */
	private String phone;
	/**
	 * 维修人员地址
	 */
	private String areaId;
	/**
	 * 维修人员详细地址
	 */
	private String addressInf;
	/**
	 * 维修人员头像
	 */
	private String headPortrait;
	/**
	 * 工作秀
	 */
	private String workPortrait;
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
	 * 用户id
	 */
	private Long userId;

	private Long typeId;
	private Long sex;

	public Long getSex() {
		return sex;
	}

	public void setSex(Long sex) {
		this.sex = sex;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
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
	 * 设置：维修人名字
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：维修人名字
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：维修人擅长技能
	 */

	/**
	 * 设置：技能服务范围
	 */
	public void setSkillScope(String skillScope) {
		this.skillScope = skillScope;
	}
	/**
	 * 获取：技能服务范围
	 */
	public String getSkillScope() {
		return skillScope;
	}
	/**
	 * 设置：维修人电话号码
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：维修人电话号码
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：维修人员地址
	 */
	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	/**
	 * 设置：维修人员详细地址
	 */
	public void setAddressInf(String addressInf) {
		this.addressInf = addressInf;
	}
	/**
	 * 获取：维修人员详细地址
	 */
	public String getAddressInf() {
		return addressInf;
	}
	/**
	 * 设置：维修人员头像
	 */
	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}
	/**
	 * 获取：维修人员头像
	 */
	public String getHeadPortrait() {
		return headPortrait;
	}
	/**
	 * 设置：工作秀
	 */
	public void setWorkPortrait(String workPortrait) {
		this.workPortrait = workPortrait;
	}
	/**
	 * 获取：工作秀
	 */
	public String getWorkPortrait() {
		return workPortrait;
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
