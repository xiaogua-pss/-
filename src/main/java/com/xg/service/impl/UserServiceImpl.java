package com.xg.service.impl;

import com.xg.mapper.UserMapper;
import com.xg.pojo.Address;
import com.xg.pojo.Admin;
import com.xg.pojo.City;
import com.xg.pojo.User;
import com.xg.service.UserService;
import com.xg.utils.GetId;
import com.xg.utils.MailUtils;
import com.xg.utils.Vo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
	private UserMapper userMapper;

	/**
	 * 查询全部
	 */
	@Override
	public List<User> findAll() {
		return userMapper.findAll();
	}

	@Override
	public void delUserById(Long[] cids) {

		if(cids!=null&&cids.length>=1){
			for (Long cid : cids) {
				userMapper.delUserById(cid);

				userMapper.delAddressById(cid);
			}
		}
	}

	@Override
	public void saveOrUpdate(Vo vo) {
		if(vo!=null&&vo.getUser()!=null){
			if(vo.getUser().getUserid()!=null){
				/**
				 * 修改
				 */
				userMapper.updateUser(vo.getUser());
				userMapper.delUserAddress(vo.getUser().getUserid());
				if(vo.getAddresss()!=null&&vo.getAddresss().size()>=1){
					for (Address address : vo.getAddresss()) {
						address.setUserid(vo.getUser().getUserid());

						userMapper.addUserAddress(address);
					}
				}
			}else{
				/**
				 * 添加
				 */
				userMapper.insetUser(vo.getUser());
				for (Address address : vo.getAddresss()) {
					address.setUserid(vo.getUser().getUserid());
					userMapper.addUserAddress(address);
				}

			}
		}
	}

	@Override
	public Vo findOne(Long userid) {


		User user = userMapper.findOne(userid);
		List<Address> addresses = userMapper.getAddressListBuUserId(userid);
		for (Address address : addresses) {
			List<City> prolist = userMapper.getCityListById(1L);
			List<City> citylist = userMapper.getCityListById(address.getProid());
			List<City> coulist = userMapper.getCityListById(address.getCityid());
			address.setProlist(prolist);
			address.setCitylist(citylist);
			address.setCoulist(coulist);
		}
		Vo vo = new Vo();
		vo.setUser(user);
		vo.setAddresss(addresses);
		return vo;
	}

	@Override
	public List<City> getCityListById(Long id) {

		return userMapper.getCityListById(id);
	}

	@Override
	public Admin getLogin(String name, String password) {

        Admin admin = userMapper.getLogin(name,password);
        return admin;
	}

    @Override
    public void register(Admin admin) {

        try {
            String uuid = GetId.getId().toString().replace("-","").substring(0,4);
            admin.setCode(uuid);
            userMapper.register(admin);
            MailUtils.secdMail(admin.getEmall(),admin.getCode());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
