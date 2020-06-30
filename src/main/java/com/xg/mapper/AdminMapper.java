package com.xg.mapper;

import com.xg.pojo.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {

    Admin getAdminCode(@Param("code") String code);

    void updateAdmin(Admin admin);
}
