package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

/**
 * 全国行政区域
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-30 14:49:23
 */
@TableName("tb_area")
public class AreaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 区域编码
	 */
	@TableId
	private String areaCode;
	/**
	 * 父级编号
	 */
	private String parentCode;
	/**
	 * 所有父级编号
	 */
	private String parentCodes;
	/**
	 * 本级排序号（升序）
	 */
	private BigDecimal treeSort;
	/**
	 * 所有级别排序号
	 */
	private String treeSorts;
	/**
	 * 是否最末级
	 */
	private String treeLeaf;
	/**
	 * 层次级别
	 */
	private BigDecimal treeLevel;
	/**
	 * 全节点名
	 */
	private String treeNames;
	/**
	 * 区域名称
	 */
	private String areaName;
	/**
	 * 区域类型
	 */
	private String areaType;
	/**
	 * 状态（0正常 1删除 2停用 3显示 4不显示）
	 */
	private String status;
	/**
	 * 创建时间
	 */
	private Date createDate;
	/**
	 * 备注信息
	 */
	private String remarks;
	/**
	 * 是否为热门城市
	 */
	private String hotCity;

	/**
	 * 设置：区域编码
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	/**
	 * 获取：区域编码
	 */
	public String getAreaCode() {
		return areaCode;
	}
	/**
	 * 设置：父级编号
	 */
	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}
	/**
	 * 获取：父级编号
	 */
	public String getParentCode() {
		return parentCode;
	}
	/**
	 * 设置：所有父级编号
	 */
	public void setParentCodes(String parentCodes) {
		this.parentCodes = parentCodes;
	}
	/**
	 * 获取：所有父级编号
	 */
	public String getParentCodes() {
		return parentCodes;
	}
	/**
	 * 设置：本级排序号（升序）
	 */
	public void setTreeSort(BigDecimal treeSort) {
		this.treeSort = treeSort;
	}
	/**
	 * 获取：本级排序号（升序）
	 */
	public BigDecimal getTreeSort() {
		return treeSort;
	}
	/**
	 * 设置：所有级别排序号
	 */
	public void setTreeSorts(String treeSorts) {
		this.treeSorts = treeSorts;
	}
	/**
	 * 获取：所有级别排序号
	 */
	public String getTreeSorts() {
		return treeSorts;
	}
	/**
	 * 设置：是否最末级
	 */
	public void setTreeLeaf(String treeLeaf) {
		this.treeLeaf = treeLeaf;
	}
	/**
	 * 获取：是否最末级
	 */
	public String getTreeLeaf() {
		return treeLeaf;
	}
	/**
	 * 设置：层次级别
	 */
	public void setTreeLevel(BigDecimal treeLevel) {
		this.treeLevel = treeLevel;
	}
	/**
	 * 获取：层次级别
	 */
	public BigDecimal getTreeLevel() {
		return treeLevel;
	}
	/**
	 * 设置：全节点名
	 */
	public void setTreeNames(String treeNames) {
		this.treeNames = treeNames;
	}
	/**
	 * 获取：全节点名
	 */
	public String getTreeNames() {
		return treeNames;
	}
	/**
	 * 设置：区域名称
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	/**
	 * 获取：区域名称
	 */
	public String getAreaName() {
		return areaName;
	}
	/**
	 * 设置：区域类型
	 */
	public void setAreaType(String areaType) {
		this.areaType = areaType;
	}
	/**
	 * 获取：区域类型
	 */
	public String getAreaType() {
		return areaType;
	}
	/**
	 * 设置：状态（0正常 1删除 2停用 3显示 4不显示）
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：状态（0正常 1删除 2停用 3显示 4不显示）
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateDate() {
		return createDate;
	}
	/**
	 * 设置：备注信息
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	/**
	 * 获取：备注信息
	 */
	public String getRemarks() {
		return remarks;
	}
	/**
	 * 设置：是否为热门城市
	 */
	public void setHotCity(String hotCity) {
		this.hotCity = hotCity;
	}
	/**
	 * 获取：是否为热门城市
	 */
	public String getHotCity() {
		return hotCity;
	}
}
