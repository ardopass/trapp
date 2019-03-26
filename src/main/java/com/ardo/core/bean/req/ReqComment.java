package com.ardo.core.bean.req;

public class ReqComment {

    private String curpagenum;//当前第几页
    private String pagecount;//每页条数
    private String type;//类型 JD:景点评论类型  GL:攻略评论类型
    private String linkId;//关联编号

    //查询参数
    private Integer start;
    private Integer end;

    @Override
    public String toString() {
        return "ReqComment{" +
                "curpagenum='" + curpagenum + '\'' +
                ", pagecount='" + pagecount + '\'' +
                ", type='" + type + '\'' +
                ", linkId='" + linkId + '\'' +
                '}';
    }

    public String getCurpagenum() {
        return curpagenum;
    }

    public void setCurpagenum(String curpagenum) {
        this.curpagenum = curpagenum;
    }

    public String getPagecount() {
        return pagecount;
    }

    public void setPagecount(String pagecount) {
        this.pagecount = pagecount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }
}
