package com.maomipuzi.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maomipuzi.system.pojo.Role;
import com.maomipuzi.system.dao.RoleMapper;
import com.maomipuzi.system.service.RoleService;
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
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> findAll() {
        //查询所有-》通用Mapper.selectAll()
        return roleMapper.selectAll();
    }

    @Override
    public Role findById(Integer id) {
        //根据ID查询
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public void add(Role role) {
        //新增角色->insertSelective 会忽略空值
        roleMapper.insertSelective(role);
    }

    @Override
    public void update(Role role) {
        //修改角色  会忽略空值
        roleMapper.updateByPrimaryKeySelective(role);
    }

    @Override
    public void delete(Integer id) {
        //删除角色
        roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Role> findList(Role role) {
        //按条件查询
        Example example = createExample(role);
        return roleMapper.selectByExample(example);
    }

    @Override
    public PageInfo<Role> findPage(Integer page, Integer size) {
        //静态分页 PageHelper.startPage(page,size)
        PageHelper.startPage(page,size);
        //查询
        List<Role> roles = roleMapper.selectAll();
        //封装PageInfo<T>
        return new PageInfo<Role>(roles);
    }

    @Override
    public PageInfo<Role> findPage(Role role, Integer page, Integer size) {
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(role);
        //执行搜索
        return new PageInfo<Role>(roleMapper.selectByExample(example));
    }

    /**
     * 条件构建
     * @param role
     * @return
     */
    public Example createExample(Role role){
        //多条件搜索
        //自定义条件搜索对象Exampl
        Example example = new Example(Role.class);
        //条件构造器
        Example.Criteria criteria = example.createCriteria();
        if(role != null){
            //模糊搜索权限
            if(!StringUtils.isEmpty(role.getPermission())){
                /**
                 * 第一个参数：Role的属性名
                 * 第二个参数：模糊搜索的条件
                 */
                criteria.andLike("permission","%"+role.getPermission()+"%");
            }
            //根据角色类型进行搜索
            if(!StringUtils.isEmpty(role.getRoleType())){
                criteria.andEqualTo("roleType",role.getRoleType());
            }
        }
        return example;
    }

}
