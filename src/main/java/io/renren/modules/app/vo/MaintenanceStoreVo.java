package io.renren.modules.app.vo;

import java.util.List;

public class MaintenanceStoreVo {
    public String address;
    public List<String> businessScope;
    public Long id;
    public String shopManagerName;
    public String shopManagerPhone;
    public String storeAddress;
    public List<String> storeBeautifulImage;
    public String storeImage;
    public String storeInfo;
    public String storeName;
    public Long userId;


    public MaintenanceStoreVo() {
    }

    public MaintenanceStoreVo(String address, List<String> businessScope, Long id, String shopManagerName, String shopManagerPhone, String storeAddress, List<String> storeBeautifulImage, String storeImage, String storeInfo, String storeName, Long userId) {
        this.address = address;
        this.businessScope = businessScope;
        this.id = id;
        this.shopManagerName = shopManagerName;
        this.shopManagerPhone = shopManagerPhone;
        this.storeAddress = storeAddress;
        this.storeBeautifulImage = storeBeautifulImage;
        this.storeImage = storeImage;
        this.storeInfo = storeInfo;
        this.storeName = storeName;
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getBusinessScope() {
        return businessScope;
    }

    public void setBusinessScope(List<String> businessScope) {
        this.businessScope = businessScope;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShopManagerName() {
        return shopManagerName;
    }

    public void setShopManagerName(String shopManagerName) {
        this.shopManagerName = shopManagerName;
    }

    public String getShopManagerPhone() {
        return shopManagerPhone;
    }

    public void setShopManagerPhone(String shopManagerPhone) {
        this.shopManagerPhone = shopManagerPhone;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public List<String> getStoreBeautifulImage() {
        return storeBeautifulImage;
    }

    public void setStoreBeautifulImage(List<String> storeBeautifulImage) {
        this.storeBeautifulImage = storeBeautifulImage;
    }

    public String getStoreImage() {
        return storeImage;
    }

    public void setStoreImage(String storeImage) {
        this.storeImage = storeImage;
    }

    public String getStoreInfo() {
        return storeInfo;
    }

    public void setStoreInfo(String storeInfo) {
        this.storeInfo = storeInfo;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
