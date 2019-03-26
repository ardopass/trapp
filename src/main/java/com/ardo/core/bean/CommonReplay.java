package com.ardo.core.bean;

/**
 * 回复
 */
public class CommonReplay {

    private String id;
    private String replayContent;
    private String userId;
    private String userName;
    private String replayTime;

    @Override
    public String toString() {
        return "CommonReplay{" +
                "id='" + id + '\'' +
                ", replayContent='" + replayContent + '\'' +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", replayTime='" + replayTime + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReplayContent() {
        return replayContent;
    }

    public void setReplayContent(String replayContent) {
        this.replayContent = replayContent;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getReplayTime() {
        return replayTime;
    }

    public void setReplayTime(String replayTime) {
        this.replayTime = replayTime;
    }
}
