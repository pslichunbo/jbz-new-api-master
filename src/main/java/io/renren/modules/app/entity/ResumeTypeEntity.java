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
 * @date 2018-08-31 09:20:03
 */
@TableName("tb_resume_type")
public class ResumeTypeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@TableId
	private Long id;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 关键字
	 */
	private String key;
	/**
	 * 0可用 1不可用
	 */
	private Long status;
	/**
	 * 创建时间
	 */
	private Date createTime;

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
	 * 设置：名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：关键字
	 */
	public void setKey(String key) {
		this.key = key;
	}
	/**
	 * 获取：关键字
	 */
	public String getKey() {
		return key;
	}
	/**
	 * 设置：0可用 1不可用
	 */
	public void setStatus(Long status) {
		this.status = status;
	}
	/**
	 * 获取：0可用 1不可用
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
}
