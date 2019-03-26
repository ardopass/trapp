package com.ardo.core.controller;

import com.ardo.common.domain.AppLog;
import com.ardo.common.tools.LogUtil;
import com.ardo.common.tools.PropertiesUtil;
import com.ardo.core.bean.req.*;
import com.ardo.core.query.CommonQuery;
import com.ardo.core.service.SpotService;
import com.ardo.core.service.UserService;
import com.xiaoleilu.hutool.io.file.FileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/spot")
public class SpotController {

    @Autowired
    private SpotService spotService;

    @Autowired
    private UserService userService;

    /**
     * 景区景点列表查询接口
     * @param request
     * @param res
     * @return
     */
    @RequestMapping(value = "querySpotList", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String querySpotList(@RequestBody ReqSpot reqSpot, HttpServletRequest request, HttpServletResponse res){

        AppLog log = new AppLog(request, "[2-1]景区景点列表数据查询接口",
                LogUtil.reqLogInfo(request, reqSpot.toString()));
        System.out.println(log.toString());
        if("TRUE".equals(PropertiesUtil.getValue("OPT.LOG"))){
            userService.log(log);
        }

        //System.out.println(LogUtil.reqLogInfo(request, reqSpot.toString()));

        String result = spotService.querySpotListForIndex(reqSpot);
        System.out.println(result);
        return result;
    }

    /**
     * 景点详情查询接口
     * @param req
     * @param res
     * @return
     */
    @RequestMapping(value = "querySpotDetail", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String querySpotDetail(@RequestBody ReqSpotDetail reqSpotDetail, HttpServletRequest req, HttpServletResponse res){

        AppLog log = new AppLog(req, "[2-2]景区景点详情查询接口",
                LogUtil.reqLogInfo(req, reqSpotDetail.toString()));
        System.out.println(log.toString());
        if("TRUE".equals(PropertiesUtil.getValue("OPT.LOG"))){
            userService.log(log);
        }

        CommonQuery query = new CommonQuery();
        query.setId(reqSpotDetail.getSpotId());
        String result = spotService.querySpotDetail(query);
        return result;
    }

    /**
     * 收藏攻略列表查询接口
     * @param reqUser
     * @param req
     * @param res
     * @return
     */
    @RequestMapping(value = "queryLikeGuideList", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String queryLikeGuideList(@RequestBody ReqUser reqUser, HttpServletRequest req, HttpServletResponse res){
        AppLog log = new AppLog(req, "[2-6]用户收藏攻略列表查询接口",
                LogUtil.reqLogInfo(req, reqUser.toString()));
        System.out.println(log.toString());
        if("TRUE".equals(PropertiesUtil.getValue("OPT.LOG"))){
            userService.log(log);
        }
        String result = spotService.queryLikeGuideList(reqUser.getUserId());
        return result;
    }

    /**
     * 攻略详情查询接口
     * @param reqGuide
     * @param req
     * @param res
     * @return
     */
    @RequestMapping(value = "queryGuideDetail", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String queryGuideDetail(@RequestBody ReqGuide reqGuide, HttpServletRequest req, HttpServletResponse res){
        AppLog log = new AppLog(req, "[2-5]攻略指南信息查询接口",
                LogUtil.reqLogInfo(req, reqGuide.toString()));
        System.out.println(log.toString());
        if("TRUE".equals(PropertiesUtil.getValue("OPT.LOG"))){
            userService.log(log);
        }
        CommonQuery query = new CommonQuery();
        //query.setId(1+"");
        query.setGuideId(reqGuide.getGuideId());
        query.setUserId(reqGuide.getUserId());
        String result = spotService.queryGuideDetail(query);
        return result;
    }

    /**
     * [2-7]攻略指南提交接口
     * @param reqGuideDetailSubmit
     * @param req
     * @param res
     * @return
     */
    @RequestMapping(value = "userGuideSubmit", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String userGuideSubmit(@RequestBody ReqGuideDetailSubmit reqGuideDetailSubmit, HttpServletRequest req, HttpServletResponse res){
        AppLog log = new AppLog(req, "[2-7]攻略指南提交接口",
                LogUtil.reqLogInfo(req, reqGuideDetailSubmit.toString()));
        System.out.println(log.toString());
        if("TRUE".equals(PropertiesUtil.getValue("OPT.LOG"))){
            userService.log(log);
        }

        String result = spotService.userGuideSubmit(reqGuideDetailSubmit);
        return result;
    }




}
