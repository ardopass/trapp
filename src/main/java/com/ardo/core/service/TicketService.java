package com.ardo.core.service;

import com.ardo.core.bean.req.ReqTicket;

public interface TicketService {

    String buyTicket(ReqTicket reqTicket);

    String queryUserTicketList(String userId);
}
