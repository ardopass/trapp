package com.ardo.core.bean;

import java.util.List;

public class CommentInfo {

    private String id;
    private String itemType;
    private String itemLinkId;
    private String comContent;
    private String userId;
    private String userName;
    private String comTime;
    private List<CommonReplay> replayList;//回复列表

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemLinkId() {
        return itemLinkId;
    }

    public void setItemLinkId(String itemLinkId) {
        this.itemLinkId = itemLinkId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getComContent() {
        return comContent;
    }

    public void setComContent(String comContent) {
        this.comContent = comContent;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getComTime() {
        return comTime;
    }

    public void setComTime(String comTime) {
        this.comTime = comTime;
    }

    public List<CommonReplay> getReplayList() {
        return replayList;
    }

    public void setReplayList(List<CommonReplay> replayList) {
        this.replayList = replayList;
    }
}
