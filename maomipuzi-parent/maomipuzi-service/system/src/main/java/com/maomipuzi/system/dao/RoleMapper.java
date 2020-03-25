package com.maomipuzi.system.dao;

import com.maomipuzi.system.Role;
import tk.mybatis.mapper.common.Mapper;
/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-03-03
 **/

/**
 * dao使用通用的Mapper
 * dao接口需要继承tk.mybatis.mapper.common.Mapper
 */

public interface RoleMapper extends Mapper<Role> {
}
