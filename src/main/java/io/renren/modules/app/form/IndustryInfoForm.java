package io.renren.modules.app.form;

public class IndustryInfoForm {

    private String title;
    private String imageLinks;
    private String content;
    private Long userId;
    private Long dellSign;

    public Long getDellSign() {
        return dellSign;
    }

    public void setDellSign(Long dellSign) {
        this.dellSign = dellSign;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageLinks() {
        return imageLinks;
    }

    public void setImageLinks(String imageLinks) {
        this.imageLinks = imageLinks;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
