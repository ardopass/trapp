package com.ardo.core.service.impl;

import com.alibaba.fastjson.JSON;
import com.ardo.common.domain.AppLog;
import com.ardo.common.domain.PageResult;
import com.ardo.common.tools.PropertiesUtil;
import com.ardo.core.bean.UserInfo;
import com.ardo.core.bean.req.ReqForgetPassWord;
import com.ardo.core.bean.req.ReqUser;
import com.ardo.core.bean.req.ReqUserGuideSubmit;
import com.ardo.core.dao.UserDao;
import com.ardo.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public String updateUserHeadPic(String workNo, String picUrl) {
        userDao.updateUserHeadPic(workNo, picUrl);
        PageResult result = new PageResult();
        result.setCode(0);
        result.setMsg("成功");
        String json = JSON.toJSON(result).toString();
        return json;
    }

    @Override
    public String queryUserHeadPic(String workNo) {
        String picUrl = userDao.queryUserHeadPic(workNo);
        String proUrl = PropertiesUtil.getValue("PRO_BASE_PATH");
        PageResult result = new PageResult();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(proUrl + picUrl);
        String json = JSON.toJSON(result).toString();
        return json;
    }

    @Override
    public String queryUserInfo(ReqUser reqUser) {
        UserInfo userInfo = userDao.queryUserInfo(reqUser);
        userInfo.setHeadPicUrl(PropertiesUtil.getValue("PRO_BASE_PATH") + userInfo.getHeadPicUrl());
        PageResult result = new PageResult();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(userInfo);
        String json = JSON.toJSON(result).toString();
        return json;
    }

    @Override
    public String login(ReqUser reqUser) {
        PageResult result = new PageResult();
        UserInfo userInfo = userDao.queryUserInfo(reqUser);
        if(userInfo!=null){
            userInfo.setHeadPicUrl(PropertiesUtil.getValue("PRO_BASE_PATH") + userInfo.getHeadPicUrl());
            if("0".equals(userInfo.getSex())){
                userInfo.setSex("女");
            }else if("1".equals(userInfo.getSex())){
                userInfo.setSex("男");
            }else{
                userInfo.setSex("未知");
            }
            if(userInfo.getPassWord().equals(reqUser.getPassWord())){
                //登陆成功
                result.setCode(0);
                result.setMsg("成功");
                result.setData(userInfo);
            }else{
                //密码不正确
                result.setCode(-1);
                result.setMsg("密码不正确！");
            }
        }else{
            //用户不存在
            result.setCode(-1);
            result.setMsg("用户不存在！");
        }
        String json = JSON.toJSON(result).toString();
        return json;
    }

    @Override
    public String register(UserInfo userInfo) {
        PageResult result = new PageResult();
        ReqUser reqUser = new ReqUser();
        reqUser.setLoginName(userInfo.getLoginName());
        UserInfo user = userDao.queryUserInfo(reqUser);
        if(user!=null){
            //账户已存在
            result.setCode(9);//9和-1代表失败
            result.setMsg("注册失败！该用户已存在！");
        }else{
            userInfo.setAccountFee("200");//默认200
            userInfo.setState("1");//默认有效
            if("女".equals(userInfo.getSex().trim())){
                userInfo.setSex("0");
            }else if("男".equals(userInfo.getSex().trim())){
                userInfo.setSex("1");
            }else{
                userInfo.setSex("-1");
            }
            userDao.register(userInfo);

            result.setCode(0);
            result.setMsg("注册成功");
            result.setData(userInfo);
        }

        String json = JSON.toJSON(result).toString();
        return json;
    }

    @Override
    public void log(AppLog log) {
        userDao.log(log);
    }

    @Override
    public String userLikeGuideSummit(ReqUserGuideSubmit reqUserGuideSubmit) {
        PageResult result = new PageResult();
        if("follow".equals(reqUserGuideSubmit.getType())){
            Integer ifCount = userDao.ifUserAlreadyFollowGuide(reqUserGuideSubmit);
            if(ifCount > 0){
                result.setMsg("已收藏，不能重复收藏！");
            }else{
                userDao.userLikeGuideFollow(reqUserGuideSubmit);
                result.setMsg("已成功收藏！");
            }
            result.setCode(0);
        }else if("cancel".equals(reqUserGuideSubmit.getType())){
            userDao.userLikeGuideCancel(reqUserGuideSubmit);
            result.setCode(0);
            result.setMsg("已取消收藏！");
        }else{
            System.out.println("未知操作！");
            result.setCode(-1);
            result.setMsg("未知操作！");
        }
        String json = JSON.toJSON(result).toString();
        return json;
    }

    @Override
    public String forgetPassWord(ReqForgetPassWord reqForgetPassWord) {
        PageResult result = new PageResult();
        ReqUser reqUser = new ReqUser();
        reqUser.setLoginName(reqForgetPassWord.getLoginName());
        UserInfo user = userDao.queryUserInfo(reqUser);
        if(user!=null){
            if(reqForgetPassWord.getCusAnswer().equals(user.getCusAnswer())){
                result.setCode(0);
                result.setMsg("恭喜找回密码，您的密码为" + user.getPassWord() + "");
            }else{
                //密保答案不正确
                result.setCode(-1);
                result.setMsg("密保答案不正确！");
            }
        }else{
            //用户不存在
            result.setCode(-1);
            result.setMsg("用户不存在！");
        }

        String json = JSON.toJSON(result).toString();
        return json;
    }
}
