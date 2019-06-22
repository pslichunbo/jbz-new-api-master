package io.renren.modules.app.vo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 货源视图表
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:22
 */
public class SourceGoodsVo implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private Long id;
	/**
	 * 出发地省
	 */
	private String startProvince;
	/**
	 * 出发地市
	 */
	private String startTown;
	/**
	 * 出发地县
	 */
	private String startCounty;
	/**
	 * 目的地省
	 */
	private String endProvince;
	/**
	 * 目的地市
	 */
	private String endTown;
	/**
	 * 目的地县
	 */
	private String endCounty;
	/**
	 * 出发地详细地址
	 */
	private String startPointAddr;
	/**
	 * 目的地详细地址
	 */
	private String endPointAddr;
	/**
	 * 货源描述
	 */
	private String cargoDescription;
	/**
	 * 用户联系方式
	 */
	private String tel;
	/**
	 * 联系人
	 */
	private String linkMan;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 距离
	 */
	private BigDecimal distance;
	/**
	 * 起点经度
	 */
	private BigDecimal startLng;
	/**
	 * 起点纬度
	 */
	private BigDecimal startLat;
	/**
	 * 终点经度
	 */
	private BigDecimal endLng;
	/**
	 * 终点纬度
	 */
	private BigDecimal endLat;
	/**
	 * 货源状态 0发布中 1待同意 2拒绝 3装货中 4装货完成 5撤销 6 过期 7异常
	 */
	private Long state;
	/**
	 * 货车运输时间
	 */
	private Date tranceportTime;
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
	 * 删除标识 1删除 0未删除
	 */
	private Long delSign;
	/**
	 * 发布人id
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
	 * 设置：出发地省
	 */
	public void setStartProvince(String startProvince) {
		this.startProvince = startProvince;
	}
	/**
	 * 获取：出发地省
	 */
	public String getStartProvince() {
		return startProvince;
	}
	/**
	 * 设置：出发地市
	 */
	public void setStartTown(String startTown) {
		this.startTown = startTown;
	}
	/**
	 * 获取：出发地市
	 */
	public String getStartTown() {
		return startTown;
	}
	/**
	 * 设置：出发地县
	 */
	public void setStartCounty(String startCounty) {
		this.startCounty = startCounty;
	}
	/**
	 * 获取：出发地县
	 */
	public String getStartCounty() {
		return startCounty;
	}
	/**
	 * 设置：目的地省
	 */
	public void setEndProvince(String endProvince) {
		this.endProvince = endProvince;
	}
	/**
	 * 获取：目的地省
	 */
	public String getEndProvince() {
		return endProvince;
	}
	/**
	 * 设置：目的地市
	 */
	public void setEndTown(String endTown) {
		this.endTown = endTown;
	}
	/**
	 * 获取：目的地市
	 */
	public String getEndTown() {
		return endTown;
	}
	/**
	 * 设置：目的地县
	 */
	public void setEndCounty(String endCounty) {
		this.endCounty = endCounty;
	}
	/**
	 * 获取：目的地县
	 */
	public String getEndCounty() {
		return endCounty;
	}
	/**
	 * 设置：出发地详细地址
	 */
	public void setStartPointAddr(String startPointAddr) {
		this.startPointAddr = startPointAddr;
	}
	/**
	 * 获取：出发地详细地址
	 */
	public String getStartPointAddr() {
		return startPointAddr;
	}
	/**
	 * 设置：目的地详细地址
	 */
	public void setEndPointAddr(String endPointAddr) {
		this.endPointAddr = endPointAddr;
	}
	/**
	 * 获取：目的地详细地址
	 */
	public String getEndPointAddr() {
		return endPointAddr;
	}
	/**
	 * 设置：货源描述
	 */
	public void setCargoDescription(String cargoDescription) {
		this.cargoDescription = cargoDescription;
	}
	/**
	 * 获取：货源描述
	 */
	public String getCargoDescription() {
		return cargoDescription;
	}
	/**
	 * 设置：用户联系方式
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	/**
	 * 获取：用户联系方式
	 */
	public String getTel() {
		return tel;
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
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：距离
	 */
	public void setDistance(BigDecimal distance) {
		this.distance = distance;
	}
	/**
	 * 获取：距离
	 */
	public BigDecimal getDistance() {
		return distance;
	}
	/**
	 * 设置：起点经度
	 */
	public void setStartLng(BigDecimal startLng) {
		this.startLng = startLng;
	}
	/**
	 * 获取：起点经度
	 */
	public BigDecimal getStartLng() {
		return startLng;
	}
	/**
	 * 设置：起点纬度
	 */
	public void setStartLat(BigDecimal startLat) {
		this.startLat = startLat;
	}
	/**
	 * 获取：起点纬度
	 */
	public BigDecimal getStartLat() {
		return startLat;
	}
	/**
	 * 设置：终点经度
	 */
	public void setEndLng(BigDecimal endLng) {
		this.endLng = endLng;
	}
	/**
	 * 获取：终点经度
	 */
	public BigDecimal getEndLng() {
		return endLng;
	}
	/**
	 * 设置：终点纬度
	 */
	public void setEndLat(BigDecimal endLat) {
		this.endLat = endLat;
	}
	/**
	 * 获取：终点纬度
	 */
	public BigDecimal getEndLat() {
		return endLat;
	}
	/**
	 * 设置：货源状态 0发布中 1待同意 2拒绝 3装货中 4装货完成 5撤销 6 过期 7异常
	 */
	public void setState(Long state) {
		this.state = state;
	}
	/**
	 * 获取：货源状态 0发布中 1待同意 2拒绝 3装货中 4装货完成 5撤销 6 过期 7异常
	 */
	public Long getState() {
		return state;
	}
	/**
	 * 设置：货车运输时间
	 */
	public void setTranceportTime(Date tranceportTime) {
		this.tranceportTime = tranceportTime;
	}
	/**
	 * 获取：货车运输时间
	 */
	public Date getTranceportTime() {
		return tranceportTime;
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
	 * 设置：删除标识 1删除 0未删除
	 */
	public void setDelSign(Long delSign) {
		this.delSign = delSign;
	}
	/**
	 * 获取：删除标识 1删除 0未删除
	 */
	public Long getDelSign() {
		return delSign;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
