package com.ardo.core.bean.req;

public class ReqUserHeadInfo {

    private String userId;
    private String userHeadPic;

    @Override
    public String toString() {
        return "ReqUserHeadInfo{" +
                "userId='" + userId + '\'' +
                ", userHeadPic='" + userHeadPic + '\'' +
                '}';
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserHeadPic() {
        return userHeadPic;
    }

    public void setUserHeadPic(String userHeadPic) {
        this.userHeadPic = userHeadPic;
    }
}
