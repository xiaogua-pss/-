package com.xg.pojo;

import java.util.List;

public class Address {

    private Long id;
    private String address;
    private Long userid;
    private Long proid;
    private Long cityid;
    private Long couid;

    private List<City> prolist;
    private List<City> citylist;
    private List<City> coulist;

    public List<City> getProlist() {
        return prolist;
    }

    public void setProlist(List<City> prolist) {
        this.prolist = prolist;
    }

    public List<City> getCitylist() {
        return citylist;
    }

    public void setCitylist(List<City> citylist) {
        this.citylist = citylist;
    }

    public List<City> getCoulist() {
        return coulist;
    }

    public void setCoulist(List<City> coulist) {
        this.coulist = coulist;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getProid() {
        return proid;
    }

    public void setProid(Long proid) {
        this.proid = proid;
    }

    public Long getCityid() {
        return cityid;
    }

    public void setCityid(Long cityid) {
        this.cityid = cityid;
    }

    public Long getCouid() {
        return couid;
    }

    public void setCouid(Long couid) {
        this.couid = couid;
    }
}
