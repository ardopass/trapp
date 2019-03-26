package com.ardo.core.bean;

public class GuideInfo {

    private String id;
    private String linkId;
    private String linkName;
    private String guideTitle;
    private String createTime;
    private String guideDetail;
    private String createUserId;
    private String createUserName;
    private String ifCurUserLike;//是否收藏 true:收藏 false:未收藏

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public String getGuideTitle() {
        return guideTitle;
    }

    public void setGuideTitle(String guideTitle) {
        this.guideTitle = guideTitle;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getGuideDetail() {
        return guideDetail;
    }

    public void setGuideDetail(String guideDetail) {
        this.guideDetail = guideDetail;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public String getIfCurUserLike() {
        return ifCurUserLike;
    }

    public void setIfCurUserLike(String ifCurUserLike) {
        this.ifCurUserLike = ifCurUserLike;
    }
}
