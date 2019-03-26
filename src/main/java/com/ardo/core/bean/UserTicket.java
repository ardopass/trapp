package com.ardo.core.bean;

public class UserTicket {

    private String ticketId;
    private String spotId;
    private String spotName;
    private String ticketFee;
    private String ticketNum;
    private String ticketBuyTime;

    @Override
    public String toString() {
        return "UserTicket{" +
                "ticketId='" + ticketId + '\'' +
                ", spotId='" + spotId + '\'' +
                ", spotName='" + spotName + '\'' +
                ", ticketFee='" + ticketFee + '\'' +
                ", ticketNum='" + ticketNum + '\'' +
                ", ticketBuyTime='" + ticketBuyTime + '\'' +
                '}';
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getSpotId() {
        return spotId;
    }

    public void setSpotId(String spotId) {
        this.spotId = spotId;
    }

    public String getSpotName() {
        return spotName;
    }

    public void setSpotName(String spotName) {
        this.spotName = spotName;
    }

    public String getTicketFee() {
        return ticketFee;
    }

    public void setTicketFee(String ticketFee) {
        this.ticketFee = ticketFee;
    }

    public String getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(String ticketNum) {
        this.ticketNum = ticketNum;
    }

    public String getTicketBuyTime() {
        return ticketBuyTime;
    }

    public void setTicketBuyTime(String ticketBuyTime) {
        this.ticketBuyTime = ticketBuyTime;
    }
}
