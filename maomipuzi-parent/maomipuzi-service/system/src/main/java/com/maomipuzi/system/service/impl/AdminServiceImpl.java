package com.maomipuzi.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maomipuzi.system.Admin;
import com.maomipuzi.system.dao.AdminMapper;
import com.maomipuzi.system.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-03-03
 **/

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public List<Admin> findAll() {
        //查询所有-》通用Mapper.selectAll()
        return adminMapper.selectAll();
    }

    @Override
    public Admin findById(Integer id) {
        //根据ID查询
        return adminMapper.selectByPrimaryKey(id);
    }

    @Override
    public void add(Admin admin) {
       /* //获取盐
        String gensalt = BCrypt.gensalt();
        //对用户的密码进行加密
        String hashpw = BCrypt.hashpw(admin.getPassword(),gensalt);
        admin.setPassword(hashpw);*/
        //新增->insertSelective 会忽略空值
        adminMapper.insertSelective(admin);
    }

    @Override
    public void update(Admin admin) {
        //修改  会忽略空值
        adminMapper.updateByPrimaryKeySelective(admin);
    }

    @Override
    public void delete(Integer id) {
        //删除
        adminMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Admin> findList(Admin admin) {
        //按条件查询
        Example example = createExample(admin);
        return adminMapper.selectByExample(example);
    }

    @Override
    public PageInfo<Admin> findPage(Integer page, Integer size) {
        //静态分页 PageHelper.startPage(page,size)
        PageHelper.startPage(page,size);
        //查询
        List<Admin> pages = adminMapper.selectAll();
        //封装PageInfo<T>
        return new PageInfo<Admin>(pages);
    }

    @Override
    public PageInfo<Admin> findPage(Admin admin, Integer page, Integer size) {
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(admin);
        //执行搜索
        return new PageInfo<Admin>(adminMapper.selectByExample(example));
    }

    /**
     * 条件构建
     * @param admin
     * @return
     */
    public Example createExample(Admin admin){
        //多条件搜索
        //自定义条件搜索对象Exampl
        Example example = new Example(Admin.class);
        //条件构造器
        Example.Criteria criteria = example.createCriteria();
        if(admin != null){
            //模糊搜索姓名
            if(!StringUtils.isEmpty(admin.getAdminName())){
                /**
                 * 第一个参数：属性名
                 * 第二个参数：模糊搜索的条件
                 */
                criteria.andLike("adminName","%"+admin.getAdminName()+"%");
            }
            //根据角色类型进行搜索
            if(!StringUtils.isEmpty(admin.getRoleType())){
                criteria.andEqualTo("roleType",admin.getRoleType());
            }
            //按状态进行搜索
            if(!StringUtils.isEmpty(admin.getEnable())){
                criteria.andEqualTo("enable",admin.getEnable());
            }
        }
        return example;
    }

    /**
     * 用户登录
     * @param admin
     * @return
     */
    @Override
    public boolean login(Admin admin) {
        //根据登录手机号码/姓名获取管理员信息
        Admin admin1 = new Admin();
        admin1.setAdminName(admin.getAdminName());
        //账号状态 1-启用  0-禁用
        admin1.setEnable(1);
        Admin adminResult = adminMapper.selectOne(admin1);
        if(adminResult == null){
            return false;
        }else{
            //对密码进行校验
            return BCrypt.checkpw(admin.getPassword(),adminResult.getPassword());
        }
    }
}
