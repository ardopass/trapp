package com.ardo.core.bean.req;

public class ReqGuide {

    private String guideId;
    private String userId;

    @Override
    public String toString() {
        return "ReqGuide{" +
                "guideId='" + guideId + '\'' +
                ", userId='" + userId + '\'' +
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
}
