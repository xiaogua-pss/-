package com.xg.controller;

import com.xg.pojo.Admin;
import com.xg.pojo.City;
import com.xg.pojo.User;
import com.xg.service.UserService;
import com.xg.utils.Result;
import com.xg.utils.Vo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.net.URLDecoder;
import java.util.List;

@Controller
public class UserController {

	@Resource
	private UserService userService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
    @ResponseBody
	public List<User> findAll(){

        return userService.findAll();
	}

	@RequestMapping("/delUserById")
    @ResponseBody
    public Result delUserById(@RequestBody Long[] cids){

	    try {
	        userService.delUserById(cids);
	        return new Result(true,"删除成功");
        }catch (Exception e){
	        e.printStackTrace();
            return new Result(false,"删除失败");
        }
    }

    @RequestMapping("/saveOrUpdate")
    @ResponseBody
    public Result saveOrUpdate(@RequestBody Vo vo){

        try {
            userService.saveOrUpdate(vo);
            return new Result(true,"保存成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"保存失败");
        }
    }

    @RequestMapping("/findOne")
    @ResponseBody
    public Vo findOne(Long userid){

        return userService.findOne(userid);
    }

    @RequestMapping("/getCityListById")
    @ResponseBody
    public List<City> getCityListById(Long id){

        return userService.getCityListById(id);
    }

    @RequestMapping("/getLogin")
    @ResponseBody
    public Result getLogin(String name,String password){

        try {
            name= URLDecoder.decode(name,"UTF-8");
        }catch (Exception e){
	        e.printStackTrace();
        }
        System.out.println("用户名:"+name);
        System.out.println("密码:"+password);
        Admin admin = userService.getLogin(name,password);
        if(admin!=null){
            if(admin.getState()==1){
                return new Result(true,"登录成功");
            }else{

                return new Result(false,"用户名或密码不正确，请重新登录");
            }
        }
        return null;
    }

    @RequestMapping("/register")
    @ResponseBody
    public Result register(@RequestBody Admin admin){

        System.out.println("========="+admin);
        try {
            userService.register(admin);
            return new Result(true,"注册成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"注册失败");
        }
    }

}
