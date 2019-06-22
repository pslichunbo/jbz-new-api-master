package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 轮播图
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:21
 */
@TableName("tb_slide_show")
public class SlideShowEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 轮播图属于哪个页面 0首页 1订单页
	 */
	private Long style;
	/**
	 * 轮播图在该页面的那个位置显示轮播图 0顶部 1底部 2左边 3右边 4中间
	 */
	private Long post;
	/**
	 * 轮播图图片地址
	 */
	private String slideShowUrl;
	/**
	 * 跳转地址
	 */
	private String skipUrl;
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
	 * 设置：轮播图属于哪个页面 0首页 1订单页
	 */
	public void setStyle(Long style) {
		this.style = style;
	}
	/**
	 * 获取：轮播图属于哪个页面 0首页 1订单页
	 */
	public Long getStyle() {
		return style;
	}
	/**
	 * 设置：轮播图在该页面的那个位置显示轮播图 0顶部 1底部 2左边 3右边 4中间
	 */
	public void setPost(Long post) {
		this.post = post;
	}
	/**
	 * 获取：轮播图在该页面的那个位置显示轮播图 0顶部 1底部 2左边 3右边 4中间
	 */
	public Long getPost() {
		return post;
	}
	/**
	 * 设置：轮播图图片地址
	 */
	public void setSlideShowUrl(String slideShowUrl) {
		this.slideShowUrl = slideShowUrl;
	}
	/**
	 * 获取：轮播图图片地址
	 */
	public String getSlideShowUrl() {
		return slideShowUrl;
	}
	/**
	 * 设置：跳转地址
	 */
	public void setSkipUrl(String skipUrl) {
		this.skipUrl = skipUrl;
	}
	/**
	 * 获取：跳转地址
	 */
	public String getSkipUrl() {
		return skipUrl;
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
