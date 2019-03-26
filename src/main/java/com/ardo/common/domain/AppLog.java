package com.ardo.common.domain;

import javax.servlet.http.HttpServletRequest;

/**
 * 日志
 */
public class AppLog {

    private String userId;
    private String userName;
    private String logModelType;
    private String reqContent;
    private String terminalInfo;

    @Override
    public String toString() {
        return "AppLog{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", logModelType='" + logModelType + '\'' +
                ", reqContent='" + reqContent + '\'' +
                ", terminalInfo='" + terminalInfo + '\'' +
                '}';
    }

    public AppLog(HttpServletRequest request, String logModelType, String reqContent) {
        this.userId = request.getParameter("userId");
        this.userName = request.getParameter("userName");
        this.terminalInfo = request.getParameter("terminalInfo");
        this.logModelType = logModelType;
        this.reqContent = reqContent;
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

    public String getLogModelType() {
        return logModelType;
    }

    public void setLogModelType(String logModelType) {
        this.logModelType = logModelType;
    }

    public String getReqContent() {
        return reqContent;
    }

    public void setReqContent(String reqContent) {
        this.reqContent = reqContent;
    }

    public String getTerminalInfo() {
        return terminalInfo;
    }

    public void setTerminalInfo(String terminalInfo) {
        this.terminalInfo = terminalInfo;
    }
}
