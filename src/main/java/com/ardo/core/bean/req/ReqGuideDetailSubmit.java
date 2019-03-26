package com.ardo.core.bean.req;

/**
 * 旅游攻略提交
 */
public class ReqGuideDetailSubmit {
    private String userId;
    private String spotId;
    private String guideTitle;
    private String guideDetail;

    @Override
    public String toString() {
        return "ReqGuideDetailSubmit{" +
                "userId='" + userId + '\'' +
                ", spotId='" + spotId + '\'' +
                ", guideTitle='" + guideTitle + '\'' +
                ", guideDetail='" + guideDetail + '\'' +
                '}';
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGuideTitle() {
        return guideTitle;
    }

    public void setGuideTitle(String guideTitle) {
        this.guideTitle = guideTitle;
    }

    public String getGuideDetail() {
        return guideDetail;
    }

    public void setGuideDetail(String guideDetail) {
        this.guideDetail = guideDetail;
    }

    public String getSpotId() {
        return spotId;
    }

    public void setSpotId(String spotId) {
        this.spotId = spotId;
    }
}
