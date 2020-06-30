package com.xg.controller;

import com.xg.pojo.Admin;
import com.xg.service.AdminService;
import com.xg.utils.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private AdminService adminService;

    @RequestMapping("/activation")
    public ModelAndView activation(String code){
        //激活查询用户
        Admin admin = adminService.getAdminCode(code);
        System.out.println("========="+code);
        admin.setState(1L);

        adminService.updateAdmin(admin);
        return new ModelAndView("redirect:/login.html");
    }

    @RequestMapping("/getTel")
    @ResponseBody
    public Result getTel(String phon){

        try{
            adminService.getTel(phon);
            return new Result(true,"发送成功");
        }catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "发送失败");
        }
    }

}
