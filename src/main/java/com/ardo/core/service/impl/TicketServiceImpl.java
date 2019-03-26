package com.ardo.core.service.impl;

import com.alibaba.fastjson.JSON;
import com.ardo.common.domain.PageResult;
import com.ardo.common.domain.Result;
import com.ardo.core.bean.ListPage;
import com.ardo.core.bean.SpotInfo;
import com.ardo.core.bean.SpotInfoPage;
import com.ardo.core.bean.UserTicket;
import com.ardo.core.bean.req.ReqTicket;
import com.ardo.core.dao.TicketDao;
import com.ardo.core.dao.UserDao;
import com.ardo.core.service.TicketService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketDao ticketDao;

    @Autowired
    private UserDao userDao;

    @Override
    public String buyTicket(ReqTicket reqTicket) {
        PageResult result = new PageResult();
        //查询余额
        String accFee = userDao.queryUserAccountFee("", reqTicket.getBuyUserId());
        System.out.println("[1]accFee=" + accFee);
        BigDecimal accFeeDec = new BigDecimal(accFee);
        BigDecimal buyFeeDec = new BigDecimal(reqTicket.getBuyFee());
        accFeeDec=accFeeDec.setScale(2, BigDecimal.ROUND_DOWN); //小数位 直接舍去，不会四舍五入
        buyFeeDec=buyFeeDec.setScale(2, BigDecimal.ROUND_DOWN); //小数位 直接舍去，不会四舍五入
        if(accFeeDec.compareTo(buyFeeDec) >= 0){//返回值 -1 小于 0 等于 1 大于
            System.out.println("账户余额大于消费金额");
            //扣款
            BigDecimal newAccFeeDec = accFeeDec.subtract(buyFeeDec);
            System.out.println("扣款后金额：" + newAccFeeDec);
            //更新账户金额
            userDao.updateAccountFee(reqTicket.getBuyUserId(), newAccFeeDec);
            //插入购票信息
            ticketDao.buyTicket(reqTicket);
            result.setCode(0);
            result.setMsg("购票成功！账户余额:" + newAccFeeDec + "元！");
        }else{
            System.out.println("账户余额不足！");
            result.setCode(-1);
            result.setMsg("账户余额不足！账户余额:" + accFeeDec + "元！");
        }

        String json = JSON.toJSON(result).toString();
        return json;
    }

    @Override
    public String queryUserTicketList(String userId) {
        ListPage<List<UserTicket>> page = new ListPage<List<UserTicket>>();
        Result result = new Result();
        List<UserTicket> list = ticketDao.queryUserTicketList(userId);
        if(list!=null && list.size()>0){
            page.setAllnum(20);
            page.setList(list);
            result.setCode(0);
            result.setMsg("成功");
            result.setData(page);
        }
        JSONObject jsonObject = JSONObject.fromObject(result);
        String json = jsonObject.toString();
        return json;
    }
}
