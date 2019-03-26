package com.ardo.core.service;

import com.ardo.core.bean.req.ReqGuideDetailSubmit;
import com.ardo.core.bean.req.ReqSpot;
import com.ardo.core.query.CommonQuery;

public interface SpotService {

    String querySpotListForIndex(ReqSpot reqSpot);

    String querySpotDetail(CommonQuery query);

    String queryGuideDetail(CommonQuery query);

    //查询用户收藏攻略列表
    String queryLikeGuideList(String userId);

    //用户攻略提交
    String userGuideSubmit(ReqGuideDetailSubmit reqGuideDetailSubmit);
}
