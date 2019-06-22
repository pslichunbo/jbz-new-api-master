package io.renren.modules.app.vo;

import io.renren.modules.app.entity.SourceGoodsEntity;

import java.util.Date;

public class OrderVo {

    public Long id;
    public String tel;
    public SourceGoodsEntity sourceGoods;
    public Long state;
    public String excInf;
    public String evaluate;
    public Long delSign;
    public Date createTime;
    public Date alterTime;
    public Date deleteTime;
    public Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public SourceGoodsEntity getSourceGoods() {
        return sourceGoods;
    }

    public void setSourceGoods(SourceGoodsEntity sourceGoods) {
        this.sourceGoods = sourceGoods;
    }

    public Long getState() {
        return state;
    }

    public void setState(Long state) {
        this.state = state;
    }

    public String getExcInf() {
        return excInf;
    }

    public void setExcInf(String excInf) {
        this.excInf = excInf;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
