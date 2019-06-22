package io.renren.modules.app.vo;

public class PersonVos {
    private String name;
    private String skillScope;
    private String areaName;
    private String headPortrait;
    private String sex;

    public String getSex(String sex) {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkillScope() {
        return skillScope;
    }

    public void setSkillScope(String skillScope) {
        this.skillScope = skillScope;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }
}
