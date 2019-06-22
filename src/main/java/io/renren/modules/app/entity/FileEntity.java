package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 文件表
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:22
 */
@TableName("tb_file")
public class FileEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 文件名
	 */
	private String name;
	/**
	 * 文件路径
	 */
	private String url;
	/**
	 * 缩略图路径
	 */
	private String smallUrl;
	/**
	 * 文件类型
	 */
	private String type;
	/**
	 * 用户id
	 */
	private Long userId;

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
	 * 设置：文件名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：文件名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：文件路径
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取：文件路径
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 设置：缩略图路径
	 */
	public void setSmallUrl(String smallUrl) {
		this.smallUrl = smallUrl;
	}
	/**
	 * 获取：缩略图路径
	 */
	public String getSmallUrl() {
		return smallUrl;
	}
	/**
	 * 设置：文件类型
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：文件类型
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：用户id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户id
	 */
	public Long getUserId() {
		return userId;
	}
}
