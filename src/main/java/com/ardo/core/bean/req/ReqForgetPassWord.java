package com.ardo.core.bean.req;

/**
 * 找回密码
 */
public class ReqForgetPassWord {

    private String loginName;
    private String cusAnswer;

    @Override
    public String toString() {
        return "ReqForgetPassWord{" +
                "loginName='" + loginName + '\'' +
                ", cusAnswer='" + cusAnswer + '\'' +
                '}';
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getCusAnswer() {
        return cusAnswer;
    }

    public void setCusAnswer(String cusAnswer) {
        this.cusAnswer = cusAnswer;
    }
}
