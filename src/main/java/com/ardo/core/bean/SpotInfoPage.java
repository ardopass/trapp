package com.ardo.core.bean;

public class SpotInfoPage<T> {

    private Integer allnum;
    private T list;

    public Integer getAllnum() {
        return allnum;
    }

    public void setAllnum(Integer allnum) {
        this.allnum = allnum;
    }

    public T getList() {
        return list;
    }

    public void setList(T list) {
        this.list = list;
    }
}
