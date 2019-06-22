package io.renren.modules.app.vo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 机械租赁表
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-31 09:20:03
 */

public class MechanicalLeaseVo  {


	/**
	 * ID
	 */

	private Long id;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 租赁价格
	 */
	private String leaseholdPrice;
	/**
	 * 地区
	 */
	private String area;
	/**
	 * 是否检测 0检测 1未检测
	 */
	private Long isTesting;
	/**
	 * 0已租 1未租
	 */
	private Long status;
	/**
	 * 类型id
	 */
	private String typeName;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 施工地区
	 */
	private String address;
	/**
	 * 工期
	 */
	private String timeLimit;
	/**
	 * 最迟进场时间
	 */
	private Date entryTime;
	/**
	 * 用户id
	 */
	private String userName;
	/**
	 * 数量
	 */
	private Long number;
	/**
	 * 结账方式
	 */
	private String checkoutMethod;
	/**
	 * 其他描述
	 */
	private String descriptions;
	/**
	 * 公司名称
	 */
	private String companyName;
	/**
	 * 联系人
	 */
	private String linkMan;
	/**
	 * 联系电话
	 */
	private String contactNumber;
	/**
	 * 0出租 1为求租
	 */
	private Long state;
	private String imagesUrl;

	public String getImagesUrl() {
		return imagesUrl;
	}

	public void setImagesUrl(String imagesUrl) {
		this.imagesUrl = imagesUrl;
	}

	private String introduction;
	private Date factoryTime;

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public Date getFactoryTime() {
		return factoryTime;
	}

	public void setFactoryTime(Date factoryTime) {
		this.factoryTime = factoryTime;
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
	 * 设置：租赁价格
	 */
	public void setLeaseholdPrice(String leaseholdPrice) {
		this.leaseholdPrice = leaseholdPrice;
	}
	/**
	 * 获取：租赁价格
	 */
	public String getLeaseholdPrice() {
		return leaseholdPrice;
	}

	/**
	 * 设置：是否检测 0检测 1未检测
	 */
	public void setIsTesting(Long isTesting) {
		this.isTesting = isTesting;
	}
	/**
	 * 获取：是否检测 0检测 1未检测
	 */
	public Long getIsTesting() {
		return isTesting;
	}
	/**
	 * 设置：0已租 1未租
	 */
	public void setStatus(Long status) {
		this.status = status;
	}
	/**
	 * 获取：0已租 1未租
	 */
	public Long getStatus() {
		return status;
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
	 * 设置：施工地区
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：施工地区
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：工期
	 */
	public void setTimeLimit(String timeLimit) {
		this.timeLimit = timeLimit;
	}
	/**
	 * 获取：工期
	 */
	public String getTimeLimit() {
		return timeLimit;
	}
	/**
	 * 设置：最迟进场时间
	 */
	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}
	/**
	 * 获取：最迟进场时间
	 */
	public Date getEntryTime() {
		return entryTime;
	}

	/**
	 * 设置：数量
	 */
	public void setNumber(Long number) {
		this.number = number;
	}
	/**
	 * 获取：数量
	 */
	public Long getNumber() {
		return number;
	}
	/**
	 * 设置：结账方式
	 */
	public void setCheckoutMethod(String checkoutMethod) {
		this.checkoutMethod = checkoutMethod;
	}
	/**
	 * 获取：结账方式
	 */
	public String getCheckoutMethod() {
		return checkoutMethod;
	}
	/**
	 * 设置：其他描述
	 */
	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}
	/**
	 * 获取：其他描述
	 */
	public String getDescriptions() {
		return descriptions;
	}
	/**
	 * 设置：公司名称
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * 获取：公司名称
	 */
	public String getCompanyName() {
		return companyName;
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
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	/**
	 * 获取：联系电话
	 */
	public String getContactNumber() {
		return contactNumber;
	}
	/**
	 * 设置：0出租 1为求租
	 */
	public void setState(Long state) {
		this.state = state;
	}
	/**
	 * 获取：0出租 1为求租
	 */
	public Long getState() {
		return state;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
