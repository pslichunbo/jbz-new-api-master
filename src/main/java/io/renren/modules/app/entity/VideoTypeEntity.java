package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 视频类型表
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:21
 */
@TableName("tb_video_type")
public class VideoTypeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 视频名称
	 */
	private String name;
	/**
	 * 关键字
	 */
	private String key;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 状态 1为可用 0为不可用
	 */
	private Long status;

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
	 * 设置：视频名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：视频名称
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
	 * 设置：状态 1为可用 0为不可用
	 */
	public void setStatus(Long status) {
		this.status = status;
	}
	/**
	 * 获取：状态 1为可用 0为不可用
	 */
	public Long getStatus() {
		return status;
	}
}
