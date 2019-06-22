package io.renren.modules.app.vo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 文章视图表
 *
 * @author jvmlz
 * @email 370261528@q.com
 * @date 2018-08-15 15:17:22
 */

public class ArticleVo implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

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
	 * 用户名字
	 */
	private String name;
	private Long userId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	private Date createTime;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getAlterTime() {
		return alterTime;
	}

	public void setAlterTime(Date alterTime) {
		this.alterTime = alterTime;
	}

	/**
	 * 修改时间
	 */
	private Date alterTime;



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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
