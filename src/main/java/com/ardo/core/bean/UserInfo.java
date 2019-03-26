package com.ardo.core.bean;

public class UserInfo {

    private String id;
    private String userName;
    private String loginName;
    private String sex;
    private String age;
    private String accountFee;
    private String headPicUrl;
    private String state;
    private String passWord;

    private String cusQuestion;//自定义问题|密保
    private String cusAnswer;//自定义答案|密保

//    @Override
//    public String toString() {
//        return "UserInfo{" +
//                "id='" + id + '\'' +
//                ", userName='" + userName + '\'' +
//                ", loginName='" + loginName + '\'' +
//                ", sex='" + sex + '\'' +
//                ", age='" + age + '\'' +
//                ", accountFee='" + accountFee + '\'' +
//                ", headPicUrl='" + headPicUrl + '\'' +
//                ", state='" + state + '\'' +
//                ", passWord='" + passWord + '\'' +
//                '}';
//    }


    @Override
    public String toString() {
        return "UserInfo{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", loginName='" + loginName + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", accountFee='" + accountFee + '\'' +
                ", headPicUrl='" + headPicUrl + '\'' +
                ", state='" + state + '\'' +
                ", passWord='" + passWord + '\'' +
                ", cusQuestion='" + cusQuestion + '\'' +
                ", cusAnswer='" + cusAnswer + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAccountFee() {
        return accountFee;
    }

    public void setAccountFee(String accountFee) {
        this.accountFee = accountFee;
    }

    public String getHeadPicUrl() {
        return headPicUrl;
    }

    public void setHeadPicUrl(String headPicUrl) {
        this.headPicUrl = headPicUrl;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getCusQuestion() {
        return cusQuestion;
    }

    public void setCusQuestion(String cusQuestion) {
        this.cusQuestion = cusQuestion;
    }

    public String getCusAnswer() {
        return cusAnswer;
    }

    public void setCusAnswer(String cusAnswer) {
        this.cusAnswer = cusAnswer;
    }
}
