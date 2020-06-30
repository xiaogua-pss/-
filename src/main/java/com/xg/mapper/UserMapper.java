package com.xg.mapper;

import com.xg.pojo.Address;
import com.xg.pojo.Admin;
import com.xg.pojo.City;
import com.xg.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UserMapper {

    List<User> findAll();

    void delUserById(@Param("userid") Long cid);

    void delAddressById(@Param("userid") Long userid);

    void updateUser(User user);

    void delUserAddress(@Param("userid") Long userid);

    void addUserAddress(Address address);

    void insetUser(User user);

    User findOne(@Param("userid") Long userid);

    List<Address> getAddressListBuUserId(@Param("userid") Long userid);

    List<City> getCityListById(Long id);

    Admin getLogin(@Param("name") String name, @Param("password") String password);

    void register(Admin admin);
}
