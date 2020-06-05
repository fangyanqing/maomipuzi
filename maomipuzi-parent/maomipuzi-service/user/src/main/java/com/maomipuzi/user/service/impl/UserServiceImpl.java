package com.maomipuzi.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maomipuzi.user.dao.UserMapper;
import com.maomipuzi.user.pojo.User;
import com.maomipuzi.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        //查询所有-》通用Mapper.selectAll()
        return userMapper.selectAll();
    }

    @Override
    public User findById(Integer id) {
        //根据ID查询
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void add(User admin) {
        //新增->insertSelective 会忽略空值
        userMapper.insertSelective(admin);
    }

    @Override
    public void update(User role) {
        //修改  会忽略空值
        userMapper.updateByPrimaryKeySelective(role);
    }

    @Override
    public void delete(Integer id) {
        //删除
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<User> findList(User user) {
        //按条件查询
        Example example = createExample(user);
        return userMapper.selectByExample(example);
    }

    @Override
    public PageInfo<User> findPage(Integer page, Integer size) {
        //静态分页 PageHelper.startPage(page,size)
        PageHelper.startPage(page,size);
        //查询
        List<User> pages = userMapper.selectAll();
        //封装PageInfo<T>
        return new PageInfo<User>(pages);
    }

    @Override
    public PageInfo<User> findPage(User user, Integer page, Integer size) {
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(user);
        //执行搜索
        return new PageInfo<User>(userMapper.selectByExample(example));
    }

    /**
     * 条件构建
     * @param user
     * @return
     */
    public Example createExample(User user){
        //多条件搜索
        //自定义条件搜索对象Exampl
        Example example = new Example(User.class);
        //条件构造器
        Example.Criteria criteria = example.createCriteria();
        if(user != null){
            //模糊搜索姓名
            if(!StringUtils.isEmpty(user.getRealName())){
                /**
                 * 第一个参数：属性名
                 * 第二个参数：模糊搜索的条件
                 */
                criteria.andLike("realName","%"+user.getRealName()+"%");
            }
            //模糊搜索昵称
            if(!StringUtils.isEmpty(user.getUserNickname())){
                criteria.andLike("userNickname","%"+user.getUserNickname()+"%");
            }
            //根据角色类型进行搜索
            if(!StringUtils.isEmpty(user.getRoleType())){
                criteria.andEqualTo("roleType",user.getRoleType());
            }
            //按状态进行搜索
            if(!StringUtils.isEmpty(user.getEnable())){
                criteria.andEqualTo("enable",user.getEnable());
            }
        }
        return example;
    }

    @Override
    public boolean login(User user) {
        User user1 = new User();
        user1.setRealName(user.getRealName());
        user1.setEnable(1);
        user1.setPassword(user.getPassword());
        User userResult = userMapper.selectOne(user1);
        if(userResult == null){
            return false;
        }else {
            return true;
        }
    }
}
