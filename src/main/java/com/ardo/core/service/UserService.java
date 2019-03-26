package com.ardo.core.service;

import com.ardo.common.domain.AppLog;
import com.ardo.core.bean.UserInfo;
import com.ardo.core.bean.req.ReqForgetPassWord;
import com.ardo.core.bean.req.ReqUser;
import com.ardo.core.bean.req.ReqUserGuideSubmit;

public interface UserService {

    String updateUserHeadPic(String workNo, String picUrl);

    String queryUserHeadPic(String workNo);

    String queryUserInfo(ReqUser reqUser);

    String login(ReqUser reqUser);

    //注册
    String register(UserInfo userInfo);

    void log(AppLog log);

    String userLikeGuideSummit(ReqUserGuideSubmit reqUserGuideSubmit);

    //找回密码
    String forgetPassWord(ReqForgetPassWord reqForgetPassWord);



}
