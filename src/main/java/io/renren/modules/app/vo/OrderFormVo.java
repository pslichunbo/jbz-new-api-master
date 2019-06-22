package io.renren.modules.app.vo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单视图表
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:22
 */

public class OrderFormVo implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private Long id;
	/**
	 * 买家电话号码
	 */
	private String tel;
	/**
	 * 货源id
	 */
	private String commodityName;
	/**
	 * 订单状态 0待同意 1已同意 2未同意 3装货中 4装货完成
5已撤销 6 异常
	 */
	private Long state;
	/**
	 * 异常信息
	 */
	private String excInf;
	/**
	 * 商品评价
	 */
	private String evaluate;
	/**
	 * 删除标识 1已删除 0未删除
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
	 * 买家id
	 */
	private String name;

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
	 * 设置：买家电话号码
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	/**
	 * 获取：买家电话号码
	 */
	public String getTel() {
		return tel;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	/**
	 * 设置：订单状态 0待同意 1已同意 2未同意 3装货中 4装货完成
5已撤销 6 异常
	 */
	public void setState(Long state) {
		this.state = state;
	}
	/**
	 * 获取：订单状态 0待同意 1已同意 2未同意 3装货中 4装货完成
5已撤销 6 异常
	 */
	public Long getState() {
		return state;
	}
	/**
	 * 设置：异常信息
	 */
	public void setExcInf(String excInf) {
		this.excInf = excInf;
	}
	/**
	 * 获取：异常信息
	 */
	public String getExcInf() {
		return excInf;
	}
	/**
	 * 设置：商品评价
	 */
	public void setEvaluate(String evaluate) {
		this.evaluate = evaluate;
	}
	/**
	 * 获取：商品评价
	 */
	public String getEvaluate() {
		return evaluate;
	}
	/**
	 * 设置：删除标识 1已删除 0未删除
	 */
	public void setDelSign(Long delSign) {
		this.delSign = delSign;
	}
	/**
	 * 获取：删除标识 1已删除 0未删除
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
