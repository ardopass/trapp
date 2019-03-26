package com.ardo.core.bean.req;

public class ReqTicket {

    private String buyUserId;
    private String buySpotId;
    private String buyFee;//总金额
    private String ticketNum;

    @Override
    public String toString() {
        return "ReqTicket{" +
                "buyUserId='" + buyUserId + '\'' +
                ", buySpotId='" + buySpotId + '\'' +
                ", buyFee='" + buyFee + '\'' +
                ", ticketNum='" + ticketNum + '\'' +
                '}';
    }

    public String getBuyUserId() {
        return buyUserId;
    }

    public void setBuyUserId(String buyUserId) {
        this.buyUserId = buyUserId;
    }

    public String getBuySpotId() {
        return buySpotId;
    }

    public void setBuySpotId(String buySpotId) {
        this.buySpotId = buySpotId;
    }

    public String getBuyFee() {
        return buyFee;
    }

    public void setBuyFee(String buyFee) {
        this.buyFee = buyFee;
    }

    public String getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(String ticketNum) {
        this.ticketNum = ticketNum;
    }
}
