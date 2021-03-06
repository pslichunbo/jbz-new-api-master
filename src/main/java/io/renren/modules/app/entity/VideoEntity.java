package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 视频表
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:21
 */
@TableName("tb_video")
public class VideoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 视频名称
	 */
	private String videoName;
	/**
	 * 视频简介
	 */
	private String videoInfo;
	/**
	 * 类型id
	 */
	private Long typeId;
	/**
	 * 视频地址
	 */
	private String videoUrl;
	/**
	 * 视频第一帧地址
	 */
	private String urlPath;
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
	 * 用户id
	 */
	private Long userId;

	private String image;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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
	 * 设置：视频名称
	 */
	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}
	/**
	 * 获取：视频名称
	 */
	public String getVideoName() {
		return videoName;
	}
	/**
	 * 设置：视频简介
	 */
	public void setVideoInfo(String videoInfo) {
		this.videoInfo = videoInfo;
	}
	/**
	 * 获取：视频简介
	 */
	public String getVideoInfo() {
		return videoInfo;
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
	 * 设置：视频地址
	 */
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	/**
	 * 获取：视频地址
	 */
	public String getVideoUrl() {
		return videoUrl;
	}
	/**
	 * 设置：视频第一帧地址
	 */
	public void setUrlPath(String urlPath) {
		this.urlPath = urlPath;
	}
	/**
	 * 获取：视频第一帧地址
	 */
	public String getUrlPath() {
		return urlPath;
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
