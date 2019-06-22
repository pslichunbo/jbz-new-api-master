package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-31 09:20:03
 */
@TableName("tb_project")
public class ProjectEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@TableId
	private Long id;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 地区
	 */
	private Long areaId;
	/**
	 * 项目图片
	 */
	private String images;
	/**
	 * 项目类型
	 */
	private Long typeId;
	/**
	 * 电话
	 */
	private String phone;
	/**
	 * 地点
	 */
	private String address;
	/**
	 * 发布时间
	 */
	private Date createTime;
	/**
	 * 承包单位
	 */
	private String contractor;
	/**
	 * 负责人
	 */
	private String principal;
	/**
	 * 负责人地址
	 */
	private String principalAddr;
	/**
	 * 状态 0可用 1不可用
	 */
	private Long status;
	/**
	 * 项目介绍
	 */
	private String projectBrief;
	/**
	 * 用户id
	 */
	private Long userId;
	private Long continues;
	private BigDecimal cost;

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public Long getContinues() {
		return continues;
	}

	public void setContinues(Long continues) {
		this.continues = continues;
	}

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
	 * 设置：地区
	 */
	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}
	/**
	 * 获取：地区
	 */
	public Long getAreaId() {
		return areaId;
	}
	/**
	 * 设置：项目图片
	 */
	public void setImages(String images) {
		this.images = images;
	}
	/**
	 * 获取：项目图片
	 */
	public String getImages() {
		return images;
	}
	/**
	 * 设置：项目类型
	 */
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
	/**
	 * 获取：项目类型
	 */
	public Long getTypeId() {
		return typeId;
	}
	/**
	 * 设置：电话
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：电话
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：地点
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：地点
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：发布时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：发布时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：承包单位
	 */
	public void setContractor(String contractor) {
		this.contractor = contractor;
	}
	/**
	 * 获取：承包单位
	 */
	public String getContractor() {
		return contractor;
	}
	/**
	 * 设置：负责人
	 */
	public void setPrincipal(String principal) {
		this.principal = principal;
	}
	/**
	 * 获取：负责人
	 */
	public String getPrincipal() {
		return principal;
	}
	/**
	 * 设置：负责人地址
	 */
	public void setPrincipalAddr(String principalAddr) {
		this.principalAddr = principalAddr;
	}
	/**
	 * 获取：负责人地址
	 */
	public String getPrincipalAddr() {
		return principalAddr;
	}
	/**
	 * 设置：状态 0可用 1不可用
	 */
	public void setStatus(Long status) {
		this.status = status;
	}
	/**
	 * 获取：状态 0可用 1不可用
	 */
	public Long getStatus() {
		return status;
	}
	/**
	 * 设置：项目介绍
	 */
	public void setProjectBrief(String projectBrief) {
		this.projectBrief = projectBrief;
	}
	/**
	 * 获取：项目介绍
	 */
	public String getProjectBrief() {
		return projectBrief;
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
