package io.renren.modules.app.vo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import io.renren.modules.app.entity.SourceGoodsEntity;
import io.renren.modules.sys.entity.SysUserEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单表Vo
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-09-29 16:33:44
 */
@TableName("tb_order_form")
public class OrderFormEntityVo implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@TableId
	private Long id;
	/**
	 * 订单号
	 */
	private String orderId;
	/**
	 * 电话号码
	 */
	private String tel;
	/**
	 * 货源实体
	 */
	private AdminSourceGoodsVo adminSourceGoodsVo;
	/**
	 * 订单状态 0已发布 1有申请 2指派中 3取货中 4运输中 5已送达 6已完成 7异常
	 */
	private Long state;
	/**
	 * 异常信息
	 */
	private String excInf;
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
	 * 货主
	 */
	private String userName;
	private Long userId;
	/**
	 * 接单时间
	 */
	private Date orderTime;
	/**
	 * 到达时间
	 */
	private Date arriveTime;

	private SysUserEntity goodsUserName;

	private String evaluate;

	private String remark;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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
	 * 设置：订单号
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	/**
	 * 获取：订单号
	 */
	public String getOrderId() {
		return orderId;
	}
	/**
	 * 设置：电话号码
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	/**
	 * 获取：电话号码
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * 设置：订单状态 0已发布 1有申请 2指派中 3取货中 4运输中 5已送达 6已完成 7异常
	 */
	public void setState(Long state) {
		this.state = state;
	}
	/**
	 * 获取：订单状态 0已发布 1有申请 2指派中 3取货中 4运输中 5已送达 6已完成 7异常
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
	/**
	 * 设置：接单时间
	 */
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	/**
	 * 获取：接单时间
	 */
	public Date getOrderTime() {
		return orderTime;
	}
	/**
	 * 设置：到达时间
	 */
	public void setArriveTime(Date arriveTime) {
		this.arriveTime = arriveTime;
	}
	/**
	 * 获取：到达时间
	 */
	public Date getArriveTime() {
		return arriveTime;
	}

	public String getEvaluate() {
		return evaluate;
	}

	public void setEvaluate(String evaluate) {
		this.evaluate = evaluate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public AdminSourceGoodsVo getAdminSourceGoodsVo() {
		return adminSourceGoodsVo;
	}

	public void setAdminSourceGoodsVo(AdminSourceGoodsVo adminSourceGoodsVo) {
		this.adminSourceGoodsVo = adminSourceGoodsVo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public SysUserEntity getGoodsUserName() {
		return goodsUserName;
	}

	public void setGoodsUserName(SysUserEntity goodsUserName) {
		this.goodsUserName = goodsUserName;
	}
}
