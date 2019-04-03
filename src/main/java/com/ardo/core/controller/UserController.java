package com.ardo.core.controller;

import com.ardo.common.domain.AppLog;
import com.ardo.common.tools.LogUtil;
import com.ardo.common.tools.PicUtil;
import com.ardo.common.tools.PropertiesUtil;
import com.ardo.core.bean.UserInfo;
import com.ardo.core.bean.req.ReqForgetPassWord;
import com.ardo.core.bean.req.ReqUser;
import com.ardo.core.bean.req.ReqUserGuideSubmit;
import com.ardo.core.bean.req.ReqUserHeadInfo;
import com.ardo.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * 用户控制层
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "login", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String login(@RequestBody ReqUser reqUser, HttpServletRequest request){
        //System.out.println(LogUtil.reqLogInfo(request, reqUser.toString()));
        AppLog log = new AppLog(request, "[1-1]用户登录接口",
                LogUtil.reqLogInfo(request, reqUser.toString()));
        System.out.println(log.toString());
        if("TRUE".equals(PropertiesUtil.getValue("OPT.LOG"))){
            userService.log(log);
        }

        String result = userService.login(reqUser);
        return result;
    }

    /**
     * [1-2]用户注册接口
     * @param userInfo
     * @param request
     * @return
     */
    @RequestMapping(value = "register", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String register(@RequestBody UserInfo userInfo, HttpServletRequest request){
        //System.out.println(LogUtil.reqLogInfo(request, userInfo.toString()));
        AppLog log = new AppLog(request, "[1-2]用户注册接口",
                LogUtil.reqLogInfo(request, userInfo.toString()));
        System.out.println(log.toString());
        if("TRUE".equals(PropertiesUtil.getValue("OPT.LOG"))){
            userService.log(log);
        }
        String result = userService.register(userInfo);
        return result;
    }

    /**
     * [1-3]找回密码
     * @param reqForgetPassWord
     * @param request
     * @return
     */
    @RequestMapping(value = "forgetPassWord", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String forgetPassWord(@RequestBody ReqForgetPassWord reqForgetPassWord, HttpServletRequest request){
        //System.out.println(LogUtil.reqLogInfo(request, userInfo.toString()));
        AppLog log = new AppLog(request, "[1-3]找回密码",
                LogUtil.reqLogInfo(request, reqForgetPassWord.toString()));
        System.out.println(log.toString());
        if("TRUE".equals(PropertiesUtil.getValue("OPT.LOG"))){
            userService.log(log);
        }

        String result = userService.forgetPassWord(reqForgetPassWord);
        return result;
    }

    @RequestMapping(value = "uploadHeadPic", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String uploadHeadPic(@RequestBody ReqUserHeadInfo reqUserHeadInfo, HttpServletRequest request){
        String result = "";
        try{
            AppLog log = new AppLog(request, "[3-1]上传头像接口",
                    LogUtil.reqLogInfo(request, reqUserHeadInfo.toString()));
            System.out.println(log.toString());
            //userService.log(log);
            String netUrl = "/upload/headpic/";

            System.out.println(LogUtil.reqLogInfo(request, reqUserHeadInfo.toString()));
            String path = request.getSession().getServletContext().getRealPath("/");
            //后期改为上层目录 webapps下
            path = path.substring(0, path.indexOf("trapp"));
            System.out.println("path=" + path);
            String lastPath = "upload" + File.separator + "headpic" + File.separator + reqUserHeadInfo.getUserId() + ".png";
            //visitUrl为入库url
            String visitUrl = netUrl + reqUserHeadInfo.getUserId() + ".png";
            String headPicPath = path + lastPath;
            System.out.println("headPicPath=" + headPicPath);
            System.out.println("visitUrl=" + visitUrl);
            //[1]上传
            PicUtil.uploadHeadPic(headPicPath, reqUserHeadInfo.getUserHeadPic());
            //[2]入库
            result = userService.updateUserHeadPic(reqUserHeadInfo.getUserId(), visitUrl);
        }catch(Exception e){
            e.printStackTrace();
        }


        return result;
    }

    @RequestMapping(value = "queryUserHeadPic", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String queryUserHeadPic(@RequestBody ReqUserHeadInfo reqUserHeadInfo, HttpServletRequest request){
        //System.out.println(LogUtil.reqLogInfo(request, reqUserHeadInfo.toString()));
        AppLog log = new AppLog(request, "[3-2]用户头像查询接口",
                LogUtil.reqLogInfo(request, reqUserHeadInfo.toString()));
        System.out.println(log.toString());
        if("TRUE".equals(PropertiesUtil.getValue("OPT.LOG"))){
            userService.log(log);
        }
        String result = userService.queryUserHeadPic(reqUserHeadInfo.getUserId());
        return result;
    }

    @RequestMapping(value = "queryUserInfo", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String queryUserInfo(@RequestBody ReqUser reqUser, HttpServletRequest request){
        //System.out.println(LogUtil.reqLogInfo(request, reqUser.toString()));
        AppLog log = new AppLog(request, "[3-3]用户基础信息查询接口",
                LogUtil.reqLogInfo(request, reqUser.toString()));
        System.out.println(log.toString());
        if("TRUE".equals(PropertiesUtil.getValue("OPT.LOG"))){
            userService.log(log);
        }
        String result = userService.queryUserInfo(reqUser);
        return result;
    }

    @RequestMapping(value = "userLikeGuideSummit", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String userLikeGuideSummit(@RequestBody ReqUserGuideSubmit reqUserGuideSubmit, HttpServletRequest request){
        AppLog log = new AppLog(request, "[4-3]用户收藏|取消攻略接口",
                LogUtil.reqLogInfo(request, reqUserGuideSubmit.toString()));
        System.out.println(log.toString());
        if("TRUE".equals(PropertiesUtil.getValue("OPT.LOG"))){
            userService.log(log);
        }

        String result = userService.userLikeGuideSummit(reqUserGuideSubmit);
        return result;
    }

//    @RequestMapping(value = "queryUserInfo", produces = "text/html;charset=UTF-8")
//    @ResponseBody
//    public String queryUserInfo(HttpServletRequest request){
//        String loginName = request.getParameter("loginName");
//        ReqUser reqUser = new ReqUser();
//        reqUser.setLoginName(loginName);
//        //System.out.println(LogUtil.reqLogInfo(request, reqUser.toString()));
//        String result = userService.queryUserInfo(reqUser);
//        return result;
//    }
}
