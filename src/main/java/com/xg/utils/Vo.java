package com.xg.utils;

import com.xg.pojo.Address;
import com.xg.pojo.User;

import java.io.Serializable;
import java.util.List;

public class Vo implements Serializable {

    private User user;
    private List<Address> addresss;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Address> getAddresss() {
        return addresss;
    }

    public void setAddresss(List<Address> addresss) {
        this.addresss = addresss;
    }
}
