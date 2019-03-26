package com.ardo.core.bean.req;

public class ReqSummitComment {

    private String linkId;//关联编号
    private String type;//类型 JD:景点评论类型  GL:攻略评论类型
    private String userId;
    private String content;

    @Override
    public String toString() {
        return "ReqSummitComment{" +
                "linkId='" + linkId + '\'' +
                ", type='" + type + '\'' +
                ", userId='" + userId + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
