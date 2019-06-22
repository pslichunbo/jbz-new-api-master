package io.renren.modules.app.vo;

import io.renren.modules.app.entity.MenuNextEntity;

import java.util.Date;
import java.util.List;

public class MenuVo {

    public Long id;
    public String menuName;
    public Long state;
    public Long sortIndex;
    public Date createTime;
    public Date alterTime;
    public Date deleteTime;
    public List<MenuNextEntity> menuNexts;
    public Long userId;
    public String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Long getState() {
        return state;
    }

    public void setState(Long state) {
        this.state = state;
    }

    public Long getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(Long sortIndex) {
        this.sortIndex = sortIndex;
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

    public List<MenuNextEntity> getMenuNexts() {
        return menuNexts;
    }

    public void setMenuNexts(List<MenuNextEntity> menuNexts) {
        this.menuNexts = menuNexts;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
