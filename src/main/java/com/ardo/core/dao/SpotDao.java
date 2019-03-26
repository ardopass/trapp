package com.ardo.core.dao;

import com.ardo.core.bean.GuideInfo;
import com.ardo.core.bean.GuideSimInfo;
import com.ardo.core.bean.SpotDetailPic;
import com.ardo.core.bean.SpotInfo;
import com.ardo.core.bean.req.ReqGuideDetailSubmit;
import com.ardo.core.bean.req.ReqSpot;
import com.ardo.core.query.CommonQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpotDao {
    //查询spot信息列表
    List<SpotInfo> querySpotListForIndex(@Param("reqSpot")ReqSpot reqSpot);
    //查询总数
    Integer querySpotListForIndexCount(@Param("reqSpot")ReqSpot reqSpot);

    //详情查询接口
    SpotInfo querySpotDetail(@Param("spot")CommonQuery query);

    List<SpotDetailPic> querySpotLinkPicList(@Param("sdp")CommonQuery query);

    //查询spot下攻略列表
    List<GuideSimInfo> querySpotLinkGuideList(@Param("query")CommonQuery query);

    //查询攻略详情
    GuideInfo querySpotLinkGuideDetail(@Param("query")CommonQuery query);

    //查询用户收藏攻略列表
    List<GuideInfo> queryLikeGuideList(@Param("userId")String userId);

    //用户攻略提交
    void userGuideSubmit(@Param("reqGuideDetailSubmit")ReqGuideDetailSubmit reqGuideDetailSubmit);
}
