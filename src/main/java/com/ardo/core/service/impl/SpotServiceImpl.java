package com.ardo.core.service.impl;

import com.alibaba.fastjson.JSON;
import com.ardo.common.domain.PageResult;
import com.ardo.common.domain.Result;
import com.ardo.common.tools.PaperUtil;
import com.ardo.core.bean.*;
import com.ardo.core.bean.req.ReqGuideDetailSubmit;
import com.ardo.core.bean.req.ReqSpot;
import com.ardo.core.dao.SpotDao;
import com.ardo.core.query.CommonQuery;
import com.ardo.core.service.SpotService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class SpotServiceImpl implements SpotService {

    @Autowired
    private SpotDao spotDao;

    @Override
    public String querySpotListForIndex(ReqSpot reqSpot) {
        System.out.println("service...");
        Map<String, Integer> map =  PaperUtil.getPageUtil(reqSpot.getCurpagenum(), reqSpot.getPagecount());
        Integer start = map.get("start");
        Integer end = map.get("end");
        reqSpot.setStart(start);
        reqSpot.setEnd(end);

        //先查总数
        Integer num = spotDao.querySpotListForIndexCount(reqSpot);
        System.out.println("num=" + num);

        String json = "";
        List<SpotInfo> spotList = spotDao.querySpotListForIndex(reqSpot);
        System.out.println("service...2");

        SpotInfoPage<List<SpotInfo>> page = new SpotInfoPage<List<SpotInfo>>();
        page.setAllnum(num);
        page.setList(spotList);

        Result<SpotInfoPage> result = new Result<SpotInfoPage>();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(page);

        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setExcludes(new String[]{"createTime", "tipInfo", "telephone", "openTime"});
        JSONObject jsonObject = JSONObject.fromObject(result, jsonConfig);
        json = jsonObject.toString();
        //JSONArray jsonArray = JSONArray.fromObject(result, jsonConfig);
        //json = jsonArray.toString();


        //json = JSON.toJSON(result).toString();
        System.out.println("service...3");
        return json;
    }

    @Override
    public String querySpotDetail(CommonQuery query) {
        String json = "";
        SpotDetailPage<SpotInfo> detail = new SpotDetailPage<SpotInfo>();
        SpotInfo spot = spotDao.querySpotDetail(query);
        detail.setDetail(spot);
        if(spot != null){
            query.setSpotId(query.getId());
            List<SpotDetailPic> sdpList = spotDao.querySpotLinkPicList(query);
            if(sdpList!=null && sdpList.size()>0){
                detail.setPiclist(sdpList);
            }
            //攻略
            List<GuideSimInfo> guideList = spotDao.querySpotLinkGuideList(query);
            if(guideList!=null && guideList.size()>0){
                detail.setGuidelist(guideList);
            }
        }
        Result<SpotDetailPage<SpotInfo>> result = new Result<SpotDetailPage<SpotInfo>>();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(detail);
        json = JSON.toJSON(result).toString();
        return json;
    }

    @Override
    public String queryGuideDetail(CommonQuery query) {
        String json = "";
        GuideInfo guideInfo = spotDao.querySpotLinkGuideDetail(query);
        PageResult result = new PageResult();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(guideInfo);
        json = JSON.toJSON(result).toString();
        return json;
    }

    @Override
    public String queryLikeGuideList(String userId) {
        String json = "";
        PageResult result = new PageResult();
        List<GuideInfo> list = spotDao.queryLikeGuideList(userId);

        result.setCode(0);
        result.setMsg("成功");
        result.setData(list);

        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setExcludes(new String[]{"guideDetail"});
        JSONObject jsonObject = JSONObject.fromObject(result, jsonConfig);
        json = jsonObject.toString();
        //json = JSON.toJSON(result).toString();
        return json;
    }

    @Override
    public String userGuideSubmit(ReqGuideDetailSubmit reqGuideDetailSubmit) {
        String json = "";
        PageResult result = new PageResult();
        spotDao.userGuideSubmit(reqGuideDetailSubmit);
        result.setCode(0);
        result.setMsg("成功");
        json = JSON.toJSON(result).toString();
        return json;
    }
}
