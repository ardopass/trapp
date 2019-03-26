package com.ardo.core.controller;

import com.ardo.common.domain.AppLog;
import com.ardo.common.tools.LogUtil;
import com.ardo.common.tools.PropertiesUtil;
import com.ardo.core.bean.req.ReqComment;
import com.ardo.core.bean.req.ReqSummitComment;
import com.ardo.core.service.CommentService;
import com.ardo.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;


    @Autowired
    private UserService userService;

    @RequestMapping(value = "queryCommentList", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String queryCommentList(@RequestBody ReqComment reqComment, HttpServletRequest request){
        //System.out.println(LogUtil.reqLogInfo(request, reqComment.toString()));
        AppLog log = new AppLog(request, "[2-3]景区景点/攻略指南评论查询接口",
                LogUtil.reqLogInfo(request, reqComment.toString()));
        System.out.println(log.toString());
        if("TRUE".equals(PropertiesUtil.getValue("OPT.LOG"))){
            userService.log(log);
        }

        String result = commentService.queryCommentListInfo(reqComment);
        return result;
    }

    @RequestMapping(value = "submitComment", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String submitComment(@RequestBody ReqSummitComment reqSummitComment, HttpServletRequest request){
        AppLog log = new AppLog(request, "[2-4]景区景点/攻略指南评论提交接口",
                LogUtil.reqLogInfo(request, reqSummitComment.toString()));
        System.out.println(log.toString());
        if("TRUE".equals(PropertiesUtil.getValue("OPT.LOG"))){
            userService.log(log);
        }

        String result = commentService.submitComment(reqSummitComment);
        return result;
    }
}
