package com.ardo.core.dao;

import com.ardo.core.bean.CommentInfo;
import com.ardo.core.bean.CommonReplay;
import com.ardo.core.bean.req.ReqComment;
import com.ardo.core.bean.req.ReqSummitComment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDao {

    List<CommentInfo> queryCommentList(@Param("reqComment") ReqComment reqComment);

    Integer queryCommentListCount(@Param("reqComment") ReqComment reqComment);

    void submitComment(@Param("reqSummitComment") ReqSummitComment reqSummitComment);

    void submitReplay(@Param("reqSummitComment") ReqSummitComment reqSummitComment);

    List<CommonReplay> queryReplayList(@Param("commentId") String commentId);
}
