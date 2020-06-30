package com.xg.service;

import com.xg.pojo.Admin;

public interface AdminService {

    Admin getAdminCode(String code);

    void updateAdmin(Admin admin);

    void getTel(String phon);
}
