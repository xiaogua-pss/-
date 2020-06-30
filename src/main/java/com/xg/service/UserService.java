package com.xg.service;

import com.xg.pojo.Admin;
import com.xg.pojo.City;
import com.xg.pojo.User;
import com.xg.utils.Vo;

import java.util.List;

public interface UserService {

	public List<User> findAll();

	void delUserById(Long[] cids);

	void saveOrUpdate(Vo vo);

	Vo findOne(Long userid);

	List<City> getCityListById(Long id);

	Admin getLogin(String name, String password);

	void register(Admin admin);
}
