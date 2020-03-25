package com.maomipuzi.goods.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maomipuzi.goods.Stock;
import com.maomipuzi.goods.dao.StockMapper;
import com.maomipuzi.goods.service.StockService;
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
public class StockServiceImpl implements StockService {

    @Autowired
    private StockMapper stockMapper;

    @Override
    public List<Stock> findAll() {
        //查询所有-》通用Mapper.selectAll()
        return stockMapper.selectAll();
    }

    @Override
    public Stock findById(Integer id) {
        //根据ID查询
        return stockMapper.selectByPrimaryKey(id);
    }

    @Override
    public void add(Stock stock) {
        //新增->insertSelective 会忽略空值
        stockMapper.insertSelective(stock);
    }

    @Override
    public void update(Stock stock) {
        //修改  会忽略空值
        stockMapper.updateByPrimaryKeySelective(stock);
    }

    @Override
    public void delete(Integer id) {
        //删除
        stockMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Stock> findList(Stock stock) {
        //按条件查询
        Example example = createExample(stock);
        return stockMapper.selectByExample(example);
    }

    @Override
    public PageInfo<Stock> findPage(Integer page, Integer size) {
        //静态分页 PageHelper.startPage(page,size)
        PageHelper.startPage(page,size);
        //查询
        List<Stock> pages = stockMapper.selectAll();
        //封装PageInfo<T>
        return new PageInfo<Stock>(pages);
    }

    @Override
    public PageInfo<Stock> findPage(Stock stock, Integer page, Integer size) {
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(stock);
        //执行搜索
        return new PageInfo<Stock>(stockMapper.selectByExample(example));
    }

    /**
     * 条件构建
     * @param stock
     * @return
     */
    public Example createExample(Stock stock){
        //多条件搜索
        //自定义条件搜索对象Exampl
        Example example = new Example(Stock.class);
        //条件构造器
        Example.Criteria criteria = example.createCriteria();
        if(stock != null){
            //模糊搜索商品编号
            if(!StringUtils.isEmpty(stock.getGoodsNo())){
                criteria.andLike("goodsNo","%"+stock.getGoodsNo()+"%");
            }
        }
        return example;
    }
}
