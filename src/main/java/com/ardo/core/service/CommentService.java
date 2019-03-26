package com.ardo.core.service;

import com.ardo.core.bean.req.ReqComment;
import com.ardo.core.bean.req.ReqSummitComment;

public interface CommentService {

    String queryCommentListInfo(ReqComment reqComment);

    String submitComment(ReqSummitComment reqSummitComment);
}
