package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 文章表
 * 
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:22
 */
@TableName("tb_article")
public class ArticleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String INDEX_NAME = "index_entity";

	public static final String TYPE = "tstype";


	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 文章标题
	 */
	private String title;
	/**
	 * 文章图片地址
	 */
	private String imageLinks;
	/**
	 * 文章内容
	 */
	private String content;
	/**
	 * 0审核通过 1审核中 2审核未通过 
	 */
	private Long type;
	/**
	 * 0未删除 1删除
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
	 * 设置：文章标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：文章标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：文章图片地址
	 */
	public void setImageLinks(String imageLinks) {
		this.imageLinks = imageLinks;
	}
	/**
	 * 获取：文章图片地址
	 */
	public String getImageLinks() {
		return imageLinks;
	}
	/**
	 * 设置：文章内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：文章内容
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：0审核通过 1审核中 2审核未通过 
	 */
	public void setType(Long type) {
		this.type = type;
	}
	/**
	 * 获取：0审核通过 1审核中 2审核未通过 
	 */
	public Long getType() {
		return type;
	}
	/**
	 * 设置：0未删除 1删除
	 */
	public void setDelSign(Long delSign) {
		this.delSign = delSign;
	}
	/**
	 * 获取：0未删除 1删除
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
