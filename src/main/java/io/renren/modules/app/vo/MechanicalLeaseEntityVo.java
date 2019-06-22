package io.renren.modules.app.vo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 机械租赁表Vo
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-10-12 14:35:13
 */
@TableName("tb_mechanical_lease")
public class MechanicalLeaseEntityVo implements Serializable {
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
	 * 租赁价格
	 */
	private BigDecimal leaseholdPrice;
	/**
	 * 地区
	 */
	private String areaName;
	private String areaCode;
	private Long areaId;
	private Long proviceId;
	private Long cityId;

	public Long getProviceId() {
		return proviceId;
	}

	public Long getCityId() {
		return cityId;
	}

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public void setProviceId(Long proviceId) {
		this.proviceId = proviceId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	/**
	 * 0已租 1未租
	 */
	private Long status;
	/**
	 * 类型id
	 */
	private String menuNextName;
	private Long menuNextId;
	private Long menuRoorId;
	private String menuRootName;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 用户id
	 */
	private String userName;
	private Long userId;
	/**
	 * 设备描述
	 */
	private String descriptions;
	/**
	 * 联系人
	 */
	private String linkMan;
	/**
	 * 联系电话
	 */
	private String contactNumber;
	/**
	 * 图片地址
	 */
	private String[] imagesUrl;
	/**
	 * 出厂时间
	 */
	private String factoryTime;
	/**
	 * 修改时间
	 */
	private Date alterTime;

	private String workingLife;

	private String tonnage;

	private String model;
	private String useDays;

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public Long getMenuNextId() {
		return menuNextId;
	}

	public void setMenuNextId(Long menuNextId) {
		this.menuNextId = menuNextId;
	}

	public Long getMenuRoorId() {
		return menuRoorId;
	}

	public void setMenuRoorId(Long menuRoorId) {
		this.menuRoorId = menuRoorId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getUseDays() {
		return useDays;
	}

	public void setUseDays(String useDays) {
		this.useDays = useDays;
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
	public void setLeaseholdPrice(BigDecimal leaseholdPrice) {
		this.leaseholdPrice = leaseholdPrice;
	}
	/**
	 * 获取：租赁价格
	 */
	public BigDecimal getLeaseholdPrice() {
		return leaseholdPrice;
	}
	/**
	 * 设置：地区
	 */
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
	 * 设置：类型id
	 */
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
	 * 设置：用户id
	 */
	/**
	 * 设置：设备描述
	 */
	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}
	/**
	 * 获取：设备描述
	 */
	public String getDescriptions() {
		return descriptions;
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
	 * 设置：图片地址
	 */
	/**
	 * 设置：出厂时间
	 */
	public void setFactoryTime(String factoryTime) {
		this.factoryTime = factoryTime;
	}
	/**
	 * 获取：出厂时间
	 */
	public String getFactoryTime() {
		return factoryTime;
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

	public String getWorkingLife() {
		return workingLife;
	}

	public void setWorkingLife(String workingLife) {
		this.workingLife = workingLife;
	}

	public String getTonnage() {
		return tonnage;
	}

	public void setTonnage(String tonnage) {
		this.tonnage = tonnage;
	}

	/**
	 * 设置：使用天数
	 */


	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getMenuNextName() {
		return menuNextName;
	}

	public void setMenuNextName(String menuNextName) {
		this.menuNextName = menuNextName;
	}

	public String getMenuRootName() {
		return menuRootName;
	}

	public void setMenuRootName(String menuRootName) {
		this.menuRootName = menuRootName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String[] getImagesUrl() {
		return imagesUrl;
	}

	public void setImagesUrl(String[] imagesUrl) {
		this.imagesUrl = imagesUrl;
	}
}
