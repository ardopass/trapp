package com.ardo.core.dao;

import com.ardo.common.domain.AppLog;
import com.ardo.core.bean.UserInfo;
import com.ardo.core.bean.req.ReqUser;
import com.ardo.core.bean.req.ReqUserGuideSubmit;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface UserDao {

    void updateUserHeadPic(@Param("workNo") String workNo, @Param("picUrl") String picPath);

    String queryUserHeadPic(@Param("workNo") String workNo);

    UserInfo queryUserInfo(@Param("reqUser") ReqUser reqUser);

    String queryUserAccountFee(@Param("workNo") String workNo, @Param("userId") String userId);

    void updateAccountFee(@Param("userId") String userId, @Param("fee") BigDecimal fee);

    //注册
    void register(@Param("userInfo")UserInfo userInfo);

    void log(@Param("log") AppLog log);

    void userLikeGuideFollow(@Param("reqUserGuideSubmit") ReqUserGuideSubmit reqUserGuideSubmit);

    void userLikeGuideCancel(@Param("reqUserGuideSubmit")ReqUserGuideSubmit reqUserGuideSubmit);

    Integer ifUserAlreadyFollowGuide(@Param("reqUserGuideSubmit")ReqUserGuideSubmit reqUserGuideSubmit);
}
