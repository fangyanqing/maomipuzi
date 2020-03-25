package com.maomipuzi.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maomipuzi.system.LoginLog;
import com.maomipuzi.system.dao.LoginLogMapper;
import com.maomipuzi.system.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-03-16 15:39
 **/
@Service
public class LoginLogServiceImpl implements LoginLogService {
    @Autowired
    private LoginLogMapper loginLogMapper;

    @Override
    public List<LoginLog> findAll() {
        //查询所有-》通用Mapper.selectAll()
        return loginLogMapper.selectAll();
    }

    @Override
    public LoginLog findById(Integer id) {
        //根据ID查询
        return loginLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public void add(LoginLog loginLog) {
        //新增->insertSelective 会忽略空值
        loginLogMapper.insertSelective(loginLog);
    }

    @Override
    public void update(LoginLog loginLog) {
        //修改  会忽略空值
        loginLogMapper.updateByPrimaryKeySelective(loginLog);
    }

    @Override
    public void delete(Integer id) {
        //删除
        loginLogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<LoginLog> findList(LoginLog loginLog) {
        //按条件查询
        Example example = createExample(loginLog);
        return loginLogMapper.selectByExample(example);
    }

    @Override
    public PageInfo<LoginLog> findPage(Integer page, Integer size) {
        //静态分页 PageHelper.startPage(page,size)
        PageHelper.startPage(page,size);
        //查询
        List<LoginLog> pages = loginLogMapper.selectAll();
        //封装PageInfo<T>
        return new PageInfo<LoginLog>(pages);
    }

    @Override
    public PageInfo<LoginLog> findPage(LoginLog loginLog, Integer page, Integer size) {
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(loginLog);
        //执行搜索
        return new PageInfo<LoginLog>(loginLogMapper.selectByExample(example));
    }

    /**
     * 条件构建
     * @param loginLog
     * @return
     */
    public Example createExample(LoginLog loginLog){
        //多条件搜索
        //自定义条件搜索对象Exampl
        Example example = new Example(LoginLog.class);
        //条件构造器
        Example.Criteria criteria = example.createCriteria();
        if(loginLog != null){
            //模糊搜索姓名
            if(!StringUtils.isEmpty(loginLog.getLoginName())){
                /**
                 * 第一个参数：属性名
                 * 第二个参数：模糊搜索的条件
                 */
                criteria.andLike("loginName","%"+loginLog.getLoginName()+"%");
            }
            //根据地区
            if(!StringUtils.isEmpty(loginLog.getLocation())){
                criteria.andLike("location","%"+loginLog.getLocation()+"%");
            }
            //根据ip
            if(!StringUtils.isEmpty(loginLog.getIp())){
                criteria.andLike("ip","%"+loginLog.getIp()+"%");
            }
            //根据
            if(!StringUtils.isEmpty(loginLog.getBrowserName())){
                criteria.andLike("browserName","%"+loginLog.getBrowserName()+"%");
            }
        }
        return example;
    }
}
