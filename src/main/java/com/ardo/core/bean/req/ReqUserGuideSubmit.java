package com.ardo.core.bean.req;

public class ReqUserGuideSubmit {

    private String guideId;
    private String userId;
    private String type;//follow|cancel

    @Override
    public String toString() {
        return "ReqUserGuideSubmit{" +
                "guideId='" + guideId + '\'' +
                ", userId='" + userId + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public String getGuideId() {
        return guideId;
    }

    public void setGuideId(String guideId) {
        this.guideId = guideId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
