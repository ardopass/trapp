package com.ardo.core.service.impl;

import com.alibaba.fastjson.JSON;
import com.ardo.common.domain.PageResult;
import com.ardo.common.domain.Result;
import com.ardo.common.tools.PaperUtil;
import com.ardo.core.bean.CommentInfo;
import com.ardo.core.bean.CommentInfoPage;
import com.ardo.core.bean.CommonReplay;
import com.ardo.core.bean.SpotInfo;
import com.ardo.core.bean.req.ReqComment;
import com.ardo.core.bean.req.ReqSummitComment;
import com.ardo.core.dao.CommentDao;
import com.ardo.core.dao.SpotDao;
import com.ardo.core.query.CommonQuery;
import com.ardo.core.service.CommentService;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private SpotDao spotDao;

    @Override
    public String queryCommentListInfo(ReqComment reqComment) {
        Map<String, Integer> map =  PaperUtil.getPageUtil(reqComment.getCurpagenum(), reqComment.getPagecount());
        Integer start = map.get("start");
        Integer end = map.get("end");
        reqComment.setStart(start);
        reqComment.setEnd(end);

        //先查spot信息
        CommonQuery query = new CommonQuery();
        query.setId(reqComment.getLinkId());
        SpotInfo spot = spotDao.querySpotDetail(query);

        //先查总数
        Integer num = commentDao.queryCommentListCount(reqComment);
        System.out.println("num=" + num);

        String json = "";
        List<CommentInfo> commentList = commentDao.queryCommentList(reqComment);

        //再遍历查询回复list
        if(commentList!=null && commentList.size()>0){
            for (int i = 0; i < commentList.size(); i++) {
                CommentInfo info = commentList.get(i);
                List<CommonReplay> replayList = commentDao.queryReplayList(info.getId());
                commentList.get(i).setReplayList(replayList);
            }

        }

        CommentInfoPage<List<CommentInfo>> page = new CommentInfoPage<List<CommentInfo>>();
        page.setAllnum(num);
        page.setLinkId(spot.getId()+"");
        page.setLinkName(spot.getName());
        page.setType(reqComment.getType());
        page.setList(commentList);

        Result<CommentInfoPage> result = new Result<CommentInfoPage>();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(page);

        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setExcludes(new String[]{"itemLinkId", "itemType"});
        JSONObject jsonObject = JSONObject.fromObject(result, jsonConfig);
        json = jsonObject.toString();

        return json;
    }

    @Override
    public String submitComment(ReqSummitComment reqSummitComment) {
        PageResult result = new PageResult();
        if("PL".equals(reqSummitComment.getType())){//评论回复
            System.out.println("回复成功");
            commentDao.submitReplay(reqSummitComment);
            result.setMsg("回复成功");
        }else{//景点或攻略回复
            commentDao.submitComment(reqSummitComment);
            result.setMsg("评论成功");
            System.out.println("评论成功");
        }
        result.setCode(0);
        String json = JSON.toJSON(result).toString();
        return json;
    }
}
