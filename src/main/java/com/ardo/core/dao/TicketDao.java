package com.ardo.core.dao;

import com.ardo.core.bean.UserTicket;
import com.ardo.core.bean.req.ReqTicket;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketDao {

    void buyTicket(@Param("reqTicket") ReqTicket reqTicket);

    List<UserTicket> queryUserTicketList(@Param("userId") String userId);
}
