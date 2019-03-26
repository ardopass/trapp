package com.ardo.common.tools;

import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 分页工具类
 */
public class PaperUtil {

    //从第几条数据开始
    public static Integer getFirstIndex(Integer page, Integer limit){
        return (page - 1) * limit;
    }

    //到第几条数据结束
    public static Integer getLastIndex(Integer page, Integer limit){
        return page * limit + 1;
    }

    public static Map<String, Integer> getPageUtil(String curPageNumStr, String limitNum){
        Map<String, Integer> map = new HashMap<String, Integer>();
        Integer curPageNum = 0;
        if(StringUtils.isNotEmpty(curPageNumStr)){
            curPageNum = Integer.parseInt(curPageNumStr);
        }else{
            System.out.println("分页参数:当前页码[" + curPageNumStr + "]为空，设置默认值[1]");
            curPageNum = 1;
        }
        Integer pageCount = 10;//默认
        if(StringUtils.isNotEmpty(limitNum)){
            pageCount = Integer.parseInt(limitNum);
        }else{
            System.out.println("分页参数:每页条数[" + limitNum + "]为空，设置默认值[10]");
            pageCount = 10;
        }
        //计算start和end
        Integer start = getFirstIndex(curPageNum, pageCount);
        Integer end = getLastIndex(curPageNum, pageCount);
        map.put("start", start);
        map.put("end", end);
        return map;
    }

}
