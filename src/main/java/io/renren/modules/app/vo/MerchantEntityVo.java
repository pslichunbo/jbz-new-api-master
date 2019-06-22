package io.renren.modules.app.vo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 信息对象Vo表
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:22
 */
public class MerchantEntityVo implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private Long id;
	/**
	 * 发布信息的标题
	 */
	private String title;
	/**
	 * 招聘、求职、维修、配件、工程承包单位、设备商名称
	 */
	private String name;
	/**
	 * 联系人
	 */
	private String linkMan;
	/**
	 * 联系电话
	 */
	private String linkTel;
	/**
	 * 招聘薪资待遇(元/月)，维修金额、工程开发(一次报价x元)、租赁报价(元/天)
	 */
	private BigDecimal money;
	/**
	 * 保存每条数据都把市那个字段放在这里，我后台要用来作标签
	 */
	private String areaSign;
	/**
	 * 地区用此字段
	 */
	private String area;
	/**
	 * 详细地址用此字段
	 */
	private String address;
	/**
	 * 描述、备注,多行文本格式
	 */
	private String remark;
	/**
	 * 工程时间、出厂时间,最迟进场时间
	 */
	private Date stataDate;
	/**
	 * 设备介绍/工期
	 */
	private String post;
	/**
	 * 图片地址
	 */
	private String imageUrl;
	/**
	 * 信息类型
	 */
	private String typeName;
	/**
	 * 设备求租所需数量
	 */
	private String countNum;
	/**
	 * 0已发布 1 取消发布 2已删除 
	 */
	private Long state;
	/**
	 * 用户id
	 */
	private String userName;
	/**
	 * 经度
	 */
	private BigDecimal lng;
	/**
	 * 纬度
	 */
	private BigDecimal lat;
	/**
	 * 用户和商家相距多少米，后台计算返回的数据
	 */
	private String distance;
	/**
	 * 1删除 0未删除
	 */
	private Long delSign;
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
	 * 标签id
	 */
	private String labelName;

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
	 * 设置：发布信息的标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：发布信息的标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：招聘、求职、维修、配件、工程承包单位、设备商名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：招聘、求职、维修、配件、工程承包单位、设备商名称
	 */
	public String getName() {
		return name;
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
	public void setLinkTel(String linkTel) {
		this.linkTel = linkTel;
	}
	/**
	 * 获取：联系电话
	 */
	public String getLinkTel() {
		return linkTel;
	}
	/**
	 * 设置：招聘薪资待遇(元/月)，维修金额、工程开发(一次报价x元)、租赁报价(元/天)
	 */
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	/**
	 * 获取：招聘薪资待遇(元/月)，维修金额、工程开发(一次报价x元)、租赁报价(元/天)
	 */
	public BigDecimal getMoney() {
		return money;
	}
	/**
	 * 设置：保存每条数据都把市那个字段放在这里，我后台要用来作标签
	 */
	public void setAreaSign(String areaSign) {
		this.areaSign = areaSign;
	}
	/**
	 * 获取：保存每条数据都把市那个字段放在这里，我后台要用来作标签
	 */
	public String getAreaSign() {
		return areaSign;
	}
	/**
	 * 设置：地区用此字段
	 */
	public void setArea(String area) {
		this.area = area;
	}
	/**
	 * 获取：地区用此字段
	 */
	public String getArea() {
		return area;
	}
	/**
	 * 设置：详细地址用此字段
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：详细地址用此字段
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：描述、备注,多行文本格式
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：描述、备注,多行文本格式
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：工程时间、出厂时间,最迟进场时间
	 */
	public void setStataDate(Date stataDate) {
		this.stataDate = stataDate;
	}
	/**
	 * 获取：工程时间、出厂时间,最迟进场时间
	 */
	public Date getStataDate() {
		return stataDate;
	}
	/**
	 * 设置：设备介绍/工期
	 */
	public void setPost(String post) {
		this.post = post;
	}
	/**
	 * 获取：设备介绍/工期
	 */
	public String getPost() {
		return post;
	}
	/**
	 * 设置：图片地址
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	/**
	 * 获取：图片地址
	 */
	public String getImageUrl() {
		return imageUrl;
	}
	/**
	 * 设置：信息类型
	 */
	/**
	 * 设置：设备求租所需数量
	 */
	public void setCountNum(String countNum) {
		this.countNum = countNum;
	}
	/**
	 * 获取：设备求租所需数量
	 */
	public String getCountNum() {
		return countNum;
	}
	/**
	 * 设置：0已发布 1 取消发布 2已删除 
	 */
	public void setState(Long state) {
		this.state = state;
	}
	/**
	 * 获取：0已发布 1 取消发布 2已删除 
	 */
	public Long getState() {
		return state;
	}
	/**
	 * 设置：用户id
	 */
	/**
	 * 设置：经度
	 */
	public void setLng(BigDecimal lng) {
		this.lng = lng;
	}
	/**
	 * 获取：经度
	 */
	public BigDecimal getLng() {
		return lng;
	}
	/**
	 * 设置：纬度
	 */
	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}
	/**
	 * 获取：纬度
	 */
	public BigDecimal getLat() {
		return lat;
	}
	/**
	 * 设置：用户和商家相距多少米，后台计算返回的数据
	 */
	public void setDistance(String distance) {
		this.distance = distance;
	}
	/**
	 * 获取：用户和商家相距多少米，后台计算返回的数据
	 */
	public String getDistance() {
		return distance;
	}
	/**
	 * 设置：1删除 0未删除
	 */
	public void setDelSign(Long delSign) {
		this.delSign = delSign;
	}
	/**
	 * 获取：1删除 0未删除
	 */
	public Long getDelSign() {
		return delSign;
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
	 * 设置：标签id
	 */

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

	public String getLabelName() {
		return labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}
}
