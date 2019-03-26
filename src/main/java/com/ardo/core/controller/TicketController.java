package com.ardo.core.controller;

import com.ardo.common.domain.AppLog;
import com.ardo.common.tools.LogUtil;
import com.ardo.common.tools.PropertiesUtil;
import com.ardo.core.bean.req.ReqTicket;
import com.ardo.core.bean.req.ReqUserHeadInfo;
import com.ardo.core.service.TicketService;
import com.ardo.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "buyTicket", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String buyTicket(@RequestBody ReqTicket reqTicket, HttpServletRequest request){
        //System.out.println(LogUtil.reqLogInfo(request, reqTicket.toString()));
        AppLog log = new AppLog(request, "[4-1]购票接口",
                LogUtil.reqLogInfo(request, reqTicket.toString()));
        System.out.println(log.toString());
        if("TRUE".equals(PropertiesUtil.getValue("OPT.LOG"))){
            userService.log(log);
        }

        String result = ticketService.buyTicket(reqTicket);
        return result;
    }

    @RequestMapping(value = "queryUserBuyTicketList", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String queryUserBuyTicketList(@RequestBody ReqTicket reqTicket, HttpServletRequest request){
        //System.out.println(LogUtil.reqLogInfo(request, reqTicket.toString()));
        AppLog log = new AppLog(request, "[4-2]用户购票列表查询接口",
                LogUtil.reqLogInfo(request, reqTicket.toString()));
        System.out.println(log.toString());
        if("TRUE".equals(PropertiesUtil.getValue("OPT.LOG"))){
            userService.log(log);
        }

        String result = ticketService.queryUserTicketList(reqTicket.getBuyUserId());
        return result;
    }
}
