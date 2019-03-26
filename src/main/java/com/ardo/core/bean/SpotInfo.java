package com.ardo.core.bean;

public class SpotInfo {

    private Integer id;
    private String name;
    private String descInfo;
    private String openTime;
    private String ticketPrice;
    private String address;
    private String telephone;
    private String trafficInfo;
    private String tipInfo;//交通状况
    private String createTime;
    private Integer sortorder;
    private Integer state;
    private String shortPicUrl;//缩略图


    @Override
    public String toString() {
        return "SpotInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", descInfo='" + descInfo + '\'' +
                ", openTime='" + openTime + '\'' +
                ", ticketPrice='" + ticketPrice + '\'' +
                ", address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                ", trafficInfo='" + trafficInfo + '\'' +
                ", tipInfo='" + tipInfo + '\'' +
                ", createTime='" + createTime + '\'' +
                ", sortorder=" + sortorder +
                ", state=" + state +
                ", shortPicUrl='" + shortPicUrl + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescInfo() {
        return descInfo;
    }

    public void setDescInfo(String descInfo) {
        this.descInfo = descInfo;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(String ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTrafficInfo() {
        return trafficInfo;
    }

    public void setTrafficInfo(String trafficInfo) {
        this.trafficInfo = trafficInfo;
    }

    public String getTipInfo() {
        return tipInfo;
    }

    public void setTipInfo(String tipInfo) {
        this.tipInfo = tipInfo;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getSortorder() {
        return sortorder;
    }

    public void setSortorder(Integer sortorder) {
        this.sortorder = sortorder;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getShortPicUrl() {
        return shortPicUrl;
    }

    public void setShortPicUrl(String shortPicUrl) {
        this.shortPicUrl = shortPicUrl;
    }
}
