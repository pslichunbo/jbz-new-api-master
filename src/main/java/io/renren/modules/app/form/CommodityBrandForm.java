package io.renren.modules.app.form;

import java.util.Date;

public class CommodityBrandForm {

    private String brandName;
    private String brandLogo;
    private String brandInfo;
    private Long typeId;
    private Long status;
    private Date createTime;
    private Long userId;
    private Long menuNextId;

    public Long getMenuNextId() {
        return menuNextId;
    }

    public void setMenuNextId(Long menuNextId) {
        this.menuNextId = menuNextId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandLogo() {
        return brandLogo;
    }

    public void setBrandLogo(String brandLogo) {
        this.brandLogo = brandLogo;
    }

    public String getBrandInfo() {
        return brandInfo;
    }

    public void setBrandInfo(String brandInfo) {
        this.brandInfo = brandInfo;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
