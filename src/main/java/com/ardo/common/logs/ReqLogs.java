package com.ardo.common.logs;

public class ReqLogs {

    private String reqUrl;//请求url
    private String reqMethod;//请求类型 POST|GET
    private String reqContent;//请求内容
    //private String reqTime;//请求时间

    @Override
    public String toString() {
        return "ReqLogs{" +
                "reqUrl='" + reqUrl + '\'' +
                ", reqMethod='" + reqMethod + '\'' +
                ", reqContent='" + reqContent + '\'' +
                //", reqTime='" + reqTime + '\'' +
                '}';
    }

    public String getReqUrl() {
        return reqUrl;
    }

    public void setReqUrl(String reqUrl) {
        this.reqUrl = reqUrl;
    }

    public String getReqMethod() {
        return reqMethod;
    }

    public void setReqMethod(String reqMethod) {
        this.reqMethod = reqMethod;
    }

    public String getReqContent() {
        return reqContent;
    }

    public void setReqContent(String reqContent) {
        this.reqContent = reqContent;
    }

    //public String getReqTime() {
    //    return reqTime;
    //}

    //public void setReqTime(String reqTime) {
    //    this.reqTime = reqTime;
    //}
}
