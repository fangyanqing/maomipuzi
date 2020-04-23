package com.maomipuzi.logistics.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maomipuzi.logistics.dao.ExpressMapper;
import com.maomipuzi.logistics.pojo.Express;
import com.maomipuzi.logistics.service.ExpressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-04-23 17:11
 **/
@Service
public class ExpressServiceImpl implements ExpressService {

    @Autowired
    private ExpressMapper expressMapper;


    /**
     * Express条件+分页查询
     * @param express 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Express> findPage(Express express, Integer page, Integer size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(express);
        //执行搜索
        return new PageInfo<Express>(expressMapper.selectByExample(example));
    }

    /**
     * Express分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Express> findPage(Integer page, Integer size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Express>(expressMapper.selectAll());
    }

    /**
     * Express条件查询
     * @param express
     * @return
     */
    @Override
    public List<Express> findList(Express express){
        //构建查询条件
        Example example = createExample(express);
        //根据构建的条件查询数据
        return expressMapper.selectByExample(example);
    }


    /**
     * Express构建查询对象
     * @param express
     * @return
     */
    public Example createExample(Express express){
        Example example=new Example(Express.class);
        Example.Criteria criteria = example.createCriteria();
        if(express!=null){
            // 快递公司ID
            if(!StringUtils.isEmpty(express.getId())){
                criteria.andEqualTo("id",express.getId());
            }
            // 快递公司编号
            if(!StringUtils.isEmpty(express.getExpressNo())){
                criteria.andEqualTo("expressNo",express.getExpressNo());
            }
            // 快递公司简称
            if(!StringUtils.isEmpty(express.getExpressCode())){
                criteria.andEqualTo("expressCode",express.getExpressCode());
            }
            // 快递公司全称
            if(!StringUtils.isEmpty(express.getExpressName())){
                criteria.andEqualTo("expressName",express.getExpressName());
            }
            // 是否显示  0-不显示 1-显示（默认）
            if(!StringUtils.isEmpty(express.getIsShow())){
                criteria.andEqualTo("isShow",express.getIsShow());
            }
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(Integer id){
        expressMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Express
     * @param express
     */
    @Override
    public void update(Express express){
        expressMapper.updateByPrimaryKey(express);
    }

    /**
     * 增加Express
     * @param express
     */
    @Override
    public void add(Express express){
        expressMapper.insert(express);
    }

    /**
     * 根据ID查询Express
     * @param id
     * @return
     */
    @Override
    public Express findById(Integer id){
        return  expressMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Express全部数据
     * @return
     */
    @Override
    public List<Express> findAll() {
        return expressMapper.selectAll();
    }
}
