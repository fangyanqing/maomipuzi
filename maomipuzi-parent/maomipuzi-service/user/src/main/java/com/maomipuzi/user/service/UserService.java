package com.maomipuzi.user.service;

import com.maomipuzi.user.pojo.User;
import service.BasicService;
/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-03-03
 **/

public interface UserService extends BasicService<User> {

    boolean login(User user);
}
