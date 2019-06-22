package io.renren.modules.app.vo;

import java.util.Date;

public class LabelVo {
    public Long id;
    public String name;
    public String description;
    public String type;
    public String delSign;
    public Date createTime;
    public Date alterTime;
    public Date deleteTime;
    public String state;
    public Long sortIndex;


    public LabelVo(Long id, String name, String description, String type, String delSign, Date createTime, Date alterTime, Date deleteTime, String state, Long sortIndex) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.delSign = delSign;
        this.createTime = createTime;
        this.alterTime = alterTime;
        this.deleteTime = deleteTime;
        this.state = state;
        this.sortIndex = sortIndex;

    }

    public LabelVo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDelSign() {
        return delSign;
    }

    public void setDelSign(String delSign) {
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(Long sortIndex) {
        this.sortIndex = sortIndex;
    }
}
