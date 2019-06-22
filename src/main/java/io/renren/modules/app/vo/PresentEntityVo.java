package io.renren.modules.app.vo;

import java.io.Serializable;
import java.util.Date;

public class PresentEntityVo implements Serializable {

    private Long id;
    /**
     * 礼品标题
     */
    private String title;
    /**
     * 礼品图片地址
     */
    private String imageLink;
    /**
     * 礼品所需金币数量
     */
    private Long price;
    /**
     * 礼品库存
     */
    private Long inventory;
    /**
     * 礼品简介
     */
    private String intro;
    /**
     * 礼品重要说明
     */
    private String importanceExplain;
    /**
     * 类型id
     */
    private String type;
    /**
     * 1删除 0未删除
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getInventory() {
        return inventory;
    }

    public void setInventory(Long inventory) {
        this.inventory = inventory;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getImportanceExplain() {
        return importanceExplain;
    }

    public void setImportanceExplain(String importanceExplain) {
        this.importanceExplain = importanceExplain;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getDelSign() {
        return delSign;
    }

    public void setDelSign(Long delSign) {
        this.delSign = delSign;
    }

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

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    public PresentEntityVo(Long id, String title, String imageLink, Long price, Long inventory, String intro, String importanceExplain, String type, Long delSign, Date createTime, Date alterTime, Date deleteTime) {
        this.id = id;
        this.title = title;
        this.imageLink = imageLink;
        this.price = price;
        this.inventory = inventory;
        this.intro = intro;
        this.importanceExplain = importanceExplain;
        this.type = type;
        this.delSign = delSign;
        this.createTime = createTime;
        this.alterTime = alterTime;
        this.deleteTime = deleteTime;
    }
}
