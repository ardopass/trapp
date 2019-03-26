package com.ardo.core.bean.req;

public class ReqSpot {

    private String curpagenum;//当前第几页
    private String pagecount;//每页条数
    private String spotName;

    //查询参数
    private Integer start;
    private Integer end;

    @Override
    public String toString() {
        return "ReqSpot{" +
                "curpagenum='" + curpagenum + '\'' +
                ", pagecount='" + pagecount + '\'' +
                ", spotName='" + spotName + '\'' +
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

    public String getSpotName() {
        return spotName;
    }

    public void setSpotName(String spotName) {
        this.spotName = spotName;
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
