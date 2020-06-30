package com.xg.service.impl;

import com.xg.mapper.AdminMapper;
import com.xg.pojo.Admin;
import com.xg.service.AdminService;
import com.xg.utils.GetId;
import com.xg.utils.SmsSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class AdminServiceImpl implements AdminService {

    private String sendCode = "";

    @Resource
    private AdminMapper adminMapper;

    @Override
    public Admin getAdminCode(String code) {

        Admin admin = adminMapper.getAdminCode(code);
        return admin;
    }

    @Override
    public void updateAdmin(Admin admin) {

        adminMapper.updateAdmin(admin);
    }

    @Override
    public void getTel(String phon) {

        String uuid = GetId.getId().toString().replace("-","").substring(0,4);
        sendCode = uuid;
        SmsSender.sendSms(uuid,phon);
    }
}
