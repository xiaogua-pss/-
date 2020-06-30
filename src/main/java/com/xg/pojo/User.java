package com.xg.pojo;

public class User {
    private Long userid;

    private String username;

    private Long userage;

    private Long address1;

    private Long address2;

    private Long address3;

    private String zhen;

    private String cun;

    private String lou;

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getUserage() {
        return userage;
    }

    public void setUserage(Long userage) {
        this.userage = userage;
    }

    public Long getAddress1() {
        return address1;
    }

    public void setAddress1(Long address1) {
        this.address1 = address1;
    }

    public Long getAddress2() {
        return address2;
    }

    public void setAddress2(Long address2) {
        this.address2 = address2;
    }

    public Long getAddress3() {
        return address3;
    }

    public void setAddress3(Long address3) {
        this.address3 = address3;
    }

    public String getZhen() {
        return zhen;
    }

    public void setZhen(String zhen) {
        this.zhen = zhen;
    }

    public String getCun() {
        return cun;
    }

    public void setCun(String cun) {
        this.cun = cun;
    }

    public String getLou() {
        return lou;
    }

    public void setLou(String lou) {
        this.lou = lou;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", userage=" + userage +
                ", address1=" + address1 +
                ", address2=" + address2 +
                ", address3=" + address3 +
                ", zhen='" + zhen + '\'' +
                ", cun='" + cun + '\'' +
                ", lou='" + lou + '\'' +
                '}';
    }
}