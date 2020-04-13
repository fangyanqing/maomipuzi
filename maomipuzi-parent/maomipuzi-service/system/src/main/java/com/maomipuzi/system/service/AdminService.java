package com.maomipuzi.system.service;

import com.maomipuzi.system.pojo.Admin;
import service.BasicService;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-03-03
 **/

public interface AdminService extends BasicService<Admin> {

    /**
     * 用户登录
     * @param admin
     * @return
     */
    boolean login(Admin admin);

    /**
     * 普通登录测试
     */
    boolean login2(Admin admin);

}
