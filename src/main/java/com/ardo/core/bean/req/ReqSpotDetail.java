package com.ardo.core.bean.req;

public class ReqSpotDetail {

    private String spotId;

    @Override
    public String toString() {
        return "ReqSpotDetail{" +
                "spotId='" + spotId + '\'' +
                '}';
    }

    public String getSpotId() {
        return spotId;
    }

    public void setSpotId(String spotId) {
        this.spotId = spotId;
    }
}
