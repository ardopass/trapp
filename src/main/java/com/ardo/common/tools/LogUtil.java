package com.ardo.common.tools;

import com.ardo.common.logs.ReqLogs;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogUtil {

    /**
     * 请求日志封装
     * @return
     */
    public static String reqLogInfo(HttpServletRequest request, String reqContent){

        //SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        //String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳

        ReqLogs reqLogs = new ReqLogs();
        reqLogs.setReqUrl(request.getRequestURI());
        reqLogs.setReqMethod(request.getMethod());
        reqLogs.setReqContent(reqContent);
        //reqLogs.setReqTime(date);

        return reqLogs.toString();
    }
}
