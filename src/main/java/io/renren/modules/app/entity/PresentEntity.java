package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 礼品表
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:22
 */
@TableName("tb_present")
public class PresentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 礼品标题
	 */
	private String title;
	/**
	 * 礼品图片地址
	 */
	private String imageLink;
	/**
	 * 礼品所需金币数量
	 */
	private Long price;
	/**
	 * 礼品库存
	 */
	private Long inventory;
	/**
	 * 礼品简介
	 */
	private String intro;
	/**
	 * 礼品重要说明
	 */
	private String importanceExplain;
	/**
	 * 类型id
	 */
	private Long typeId;
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
	 * 设置：礼品标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：礼品标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：礼品图片地址
	 */
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}
	/**
	 * 获取：礼品图片地址
	 */
	public String getImageLink() {
		return imageLink;
	}
	/**
	 * 设置：礼品所需金币数量
	 */
	public void setPrice(Long price) {
		this.price = price;
	}
	/**
	 * 获取：礼品所需金币数量
	 */
	public Long getPrice() {
		return price;
	}
	/**
	 * 设置：礼品库存
	 */
	public void setInventory(Long inventory) {
		this.inventory = inventory;
	}
	/**
	 * 获取：礼品库存
	 */
	public Long getInventory() {
		return inventory;
	}
	/**
	 * 设置：礼品简介
	 */
	public void setIntro(String intro) {
		this.intro = intro;
	}
	/**
	 * 获取：礼品简介
	 */
	public String getIntro() {
		return intro;
	}
	/**
	 * 设置：礼品重要说明
	 */
	public void setImportanceExplain(String importanceExplain) {
		this.importanceExplain = importanceExplain;
	}
	/**
	 * 获取：礼品重要说明
	 */
	public String getImportanceExplain() {
		return importanceExplain;
	}
	/**
	 * 设置：类型id
	 */
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
	/**
	 * 获取：类型id
	 */
	public Long getTypeId() {
		return typeId;
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

}
