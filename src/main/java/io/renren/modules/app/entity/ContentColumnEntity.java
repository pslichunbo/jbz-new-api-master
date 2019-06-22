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
 * @date 2018-08-20 15:02:48
 */
@TableName("tb_content_column")
public class ContentColumnEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 
	 */
	private String columnKey;
	/**
	 * 
	 */
	private Long contentCount;
	/**
	 * 
	 */
	private String description;
	/**
	 * 
	 */
	private String href;
	/**
	 * 
	 */
	private Long level;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private Long publishedCount;
	/**
	 * 
	 */
	private Long singlePage;
	/**
	 * 
	 */
	private Long sortIndex;
	/**
	 * 
	 */
	private Long state;
	/**
	 * 
	 */
	private Long subColumn;


	/**
	 * 
	 */
	private Long parentId;


	private String partsId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getColumnKey() {
		return columnKey;
	}

	public void setColumnKey(String columnKey) {
		this.columnKey = columnKey;
	}

	public Long getContentCount() {
		return contentCount;
	}

	public void setContentCount(Long contentCount) {
		this.contentCount = contentCount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public Long getLevel() {
		return level;
	}

	public void setLevel(Long level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPublishedCount() {
		return publishedCount;
	}

	public void setPublishedCount(Long publishedCount) {
		this.publishedCount = publishedCount;
	}


	public Long getSortIndex() {
		return sortIndex;
	}

	public void setSortIndex(Long sortIndex) {
		this.sortIndex = sortIndex;
	}

	public Long getState() {
		return state;
	}

	public void setState(Long state) {
		this.state = state;
	}

	public Long getSinglePage() {
		return singlePage;
	}

	public void setSinglePage(Long singlePage) {
		this.singlePage = singlePage;
	}

	public Long getSubColumn() {
		return subColumn;
	}

	public void setSubColumn(Long subColumn) {
		this.subColumn = subColumn;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getPartsId() {
		return partsId;
	}

	public void setPartsId(String partsId) {
		this.partsId = partsId;
	}
}
