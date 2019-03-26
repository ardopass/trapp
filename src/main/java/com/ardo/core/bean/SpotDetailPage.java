package com.ardo.core.bean;

import java.util.List;

public class SpotDetailPage<T> {

    private T detail;
    private List<SpotDetailPic> piclist;
    private List<GuideSimInfo> guidelist;//攻略列表

    public T getDetail() {
        return detail;
    }

    public void setDetail(T detail) {
        this.detail = detail;
    }

    public List<SpotDetailPic> getPiclist() {
        return piclist;
    }

    public void setPiclist(List<SpotDetailPic> piclist) {
        this.piclist = piclist;
    }

    public List<GuideSimInfo> getGuidelist() {
        return guidelist;
    }

    public void setGuidelist(List<GuideSimInfo> guidelist) {
        this.guidelist = guidelist;
    }
}
