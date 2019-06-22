package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-22 16:24:53
 */
@TableName("tb_config")
public class ConfigEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	@TableId
	private Long id;
	/**
	 * key
	 */
	private String configKey;
	/**
	 * 类型
	 */
	private Long type;
	/**
	 * 配置名字
	 */
	private String name;
	/**
	 * 配置描述
	 */
	private String description;
	/**
	 * 配置标题
	 */
	private String title;
	/**
	 * 图片地址
	 */
	private String image;
	/**
	 * 添加时间
	 */
	private Date createDate;
	/**
	 * 更新时间
	 */
	private Date updateDate;
	/**
	 * 配置模块
	 */
	private String module;
	/**
	 * 是否允许编辑
	 */
	private String editable;
	/**
	 * 是否允许删除
	 */
	private String deletable;
	/**
	 * 是否允许
	 */
	private String visible;
	/**
	 * 顺序
	 */
	private Long sortOrder;
	/**
	 * 选项
	 */
	private String options;
	/**
	 * 
	 */
	private String strVal;
	/**
	 * 
	 */
	private String intVal;
	/**
	 * 
	 */
	private String floatVal;
	/**
	 * 
	 */
	private String booleanVal;
	/**
	 * 
	 */
	private String textVal;

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
	 * 设置：key
	 */
	public void setConfigKey(String configKey) {
		this.configKey = configKey;
	}
	/**
	 * 获取：key
	 */
	public String getConfigKey() {
		return configKey;
	}
	/**
	 * 设置：类型
	 */
	public void setType(Long type) {
		this.type = type;
	}
	/**
	 * 获取：类型
	 */
	public Long getType() {
		return type;
	}
	/**
	 * 设置：配置名字
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：配置名字
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：配置描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 获取：配置描述
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * 设置：配置标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：配置标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：图片地址
	 */
	public void setImage(String image) {
		this.image = image;
	}
	/**
	 * 获取：图片地址
	 */
	public String getImage() {
		return image;
	}
	/**
	 * 设置：添加时间
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：添加时间
	 */
	public Date getCreateDate() {
		return createDate;
	}
	/**
	 * 设置：更新时间
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdateDate() {
		return updateDate;
	}
	/**
	 * 设置：配置模块
	 */
	public void setModule(String module) {
		this.module = module;
	}
	/**
	 * 获取：配置模块
	 */
	public String getModule() {
		return module;
	}
	/**
	 * 设置：是否允许编辑
	 */
	public void setEditable(String editable) {
		this.editable = editable;
	}
	/**
	 * 获取：是否允许编辑
	 */
	public String getEditable() {
		return editable;
	}
	/**
	 * 设置：是否允许删除
	 */
	public void setDeletable(String deletable) {
		this.deletable = deletable;
	}
	/**
	 * 获取：是否允许删除
	 */
	public String getDeletable() {
		return deletable;
	}
	/**
	 * 设置：是否允许
	 */
	public void setVisible(String visible) {
		this.visible = visible;
	}
	/**
	 * 获取：是否允许
	 */
	public String getVisible() {
		return visible;
	}
	/**
	 * 设置：顺序
	 */
	public void setSortOrder(Long sortOrder) {
		this.sortOrder = sortOrder;
	}
	/**
	 * 获取：顺序
	 */
	public Long getSortOrder() {
		return sortOrder;
	}
	/**
	 * 设置：选项
	 */
	public void setOptions(String options) {
		this.options = options;
	}
	/**
	 * 获取：选项
	 */
	public String getOptions() {
		return options;
	}
	/**
	 * 设置：
	 */
	public void setStrVal(String strVal) {
		this.strVal = strVal;
	}
	/**
	 * 获取：
	 */
	public String getStrVal() {
		return strVal;
	}
	/**
	 * 设置：
	 */
	public void setIntVal(String intVal) {
		this.intVal = intVal;
	}
	/**
	 * 获取：
	 */
	public String getIntVal() {
		return intVal;
	}
	/**
	 * 设置：
	 */
	public void setFloatVal(String floatVal) {
		this.floatVal = floatVal;
	}
	/**
	 * 获取：
	 */
	public String getFloatVal() {
		return floatVal;
	}
	/**
	 * 设置：
	 */
	public void setBooleanVal(String booleanVal) {
		this.booleanVal = booleanVal;
	}
	/**
	 * 获取：
	 */
	public String getBooleanVal() {
		return booleanVal;
	}
	/**
	 * 设置：
	 */
	public void setTextVal(String textVal) {
		this.textVal = textVal;
	}
	/**
	 * 获取：
	 */
	public String getTextVal() {
		return textVal;
	}
}
