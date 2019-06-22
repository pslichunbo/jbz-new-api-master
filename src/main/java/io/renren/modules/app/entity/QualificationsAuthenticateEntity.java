package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 身份
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-09-29 14:59:42
 */
@TableName("tb_qualifications_authenticate")
public class QualificationsAuthenticateEntity implements Serializable {
	private static final long serialVersionUID = 1L;



	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 身份标识
	 */
	private String identitySign;
	/**
	 * 0 证件审核中 1证件审核通过 2证件审核未通过
	 */
	private Long state;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改时间
	 */
	private Date alterTime;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 驾龄
	 */
	private String drivingAge;
	/**
	 * 联系电话
	 */
	private String telephoneNumber;
	/**
	 * 驾驶证正面
	 */
	private String drivingLicenseFront;
	/**
	 * 驾驶证反面
	 */
	private String drivingLicenseContrary;
	/**
	 * 行驶证正面
	 */
	private String runningLicenseFront;
	/**
	 * 行驶证反面
	 */
	private String runningLicenseContrary;
	/**
	 * 自拍照
	 */
	private String photograph;
	/**
	 * 车辆外观照
	 */
	private String vehicle;
	/**
	 * 车牌照
	 */
	private String licensePlatePhoto;


	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

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
	 * 设置：身份标识
	 */
	public void setIdentitySign(String identitySign) {
		this.identitySign = identitySign;
	}
	/**
	 * 获取：身份标识
	 */
	public String getIdentitySign() {
		return identitySign;
	}
	/**
	 * 设置：0 证件审核中 1证件审核通过 2证件审核未通过
	 */
	public void setState(Long state) {
		this.state = state;
	}
	/**
	 * 获取：0 证件审核中 1证件审核通过 2证件审核未通过
	 */
	public Long getState() {
		return state;
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
	 * 设置：驾龄
	 */
	public void setDrivingAge(String drivingAge) {
		this.drivingAge = drivingAge;
	}
	/**
	 * 获取：驾龄
	 */
	public String getDrivingAge() {
		return drivingAge;
	}
	/**
	 * 设置：联系电话
	 */
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	/**
	 * 获取：联系电话
	 */
	public String getTelephoneNumber() {
		return telephoneNumber;
	}
	/**
	 * 设置：驾驶证正面
	 */
	public void setDrivingLicenseFront(String drivingLicenseFront) {
		this.drivingLicenseFront = drivingLicenseFront;
	}
	/**
	 * 获取：驾驶证正面
	 */
	public String getDrivingLicenseFront() {
		return drivingLicenseFront;
	}
	/**
	 * 设置：驾驶证反面
	 */
	public void setDrivingLicenseContrary(String drivingLicenseContrary) {
		this.drivingLicenseContrary = drivingLicenseContrary;
	}
	/**
	 * 获取：驾驶证反面
	 */
	public String getDrivingLicenseContrary() {
		return drivingLicenseContrary;
	}
	/**
	 * 设置：行驶证正面
	 */
	public void setRunningLicenseFront(String runningLicenseFront) {
		this.runningLicenseFront = runningLicenseFront;
	}
	/**
	 * 获取：行驶证正面
	 */
	public String getRunningLicenseFront() {
		return runningLicenseFront;
	}
	/**
	 * 设置：行驶证反面
	 */
	public void setRunningLicenseContrary(String runningLicenseContrary) {
		this.runningLicenseContrary = runningLicenseContrary;
	}
	/**
	 * 获取：行驶证反面
	 */
	public String getRunningLicenseContrary() {
		return runningLicenseContrary;
	}
	/**
	 * 设置：自拍照
	 */
	public void setPhotograph(String photograph) {
		this.photograph = photograph;
	}
	/**
	 * 获取：自拍照
	 */
	public String getPhotograph() {
		return photograph;
	}
	/**
	 * 设置：车辆外观照
	 */
	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}
	/**
	 * 获取：车辆外观照
	 */
	public String getVehicle() {
		return vehicle;
	}
	/**
	 * 设置：车牌照
	 */
	public void setLicensePlatePhoto(String licensePlatePhoto) {
		this.licensePlatePhoto = licensePlatePhoto;
	}
	/**
	 * 获取：车牌照
	 */
	public String getLicensePlatePhoto() {
		return licensePlatePhoto;
	}
}
