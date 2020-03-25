package com.maomipuzi.goods.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maomipuzi.goods.pojo.Type;
import com.maomipuzi.goods.dao.TypeMapper;
import com.maomipuzi.goods.service.TypeService;
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
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;

    @Override
    public List<Type> findAll() {
        //查询所有-》通用Mapper.selectAll()
        return typeMapper.selectAll();
    }

    @Override
    public Type findById(Integer id) {
        //根据ID查询
        return typeMapper.selectByPrimaryKey(id);
    }

    @Override
    public void add(Type type) {
        //新增->insertSelective 会忽略空值
        typeMapper.insertSelective(type);
    }

    @Override
    public void update(Type type) {
        //修改  会忽略空值
        typeMapper.updateByPrimaryKeySelective(type);
    }

    @Override
    public void delete(Integer id) {
        //删除
        typeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Type> findList(Type type) {
        //按条件查询
        Example example = createExample(type);
        return typeMapper.selectByExample(example);
    }

    @Override
    public PageInfo<Type> findPage(Integer page, Integer size) {
        //静态分页 PageHelper.startPage(page,size)
        PageHelper.startPage(page,size);
        //查询
        List<Type> pages = typeMapper.selectAll();
        //封装PageInfo<T>
        return new PageInfo<Type>(pages);
    }

    @Override
    public PageInfo<Type> findPage(Type type, Integer page, Integer size) {
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(type);
        //执行搜索
        return new PageInfo<Type>(typeMapper.selectByExample(example));
    }

    /**
     * 条件构建
     * @param type
     * @return
     */
    public Example createExample(Type type){
        //多条件搜索
        //自定义条件搜索对象Exampl
        Example example = new Example(Type.class);
        //条件构造器
        Example.Criteria criteria = example.createCriteria();
        if(type != null){
            //模糊搜索类型名称
            if(!StringUtils.isEmpty(type.getTypeName())){
                criteria.andLike("typeName","%"+type.getTypeName()+"%");
            }
            //根据类型状态进行搜索
            if(!StringUtils.isEmpty(type.getTypeStatus())){
                criteria.andEqualTo("typeStatus",type.getTypeStatus());
            }

        }
        return example;
    }
}
