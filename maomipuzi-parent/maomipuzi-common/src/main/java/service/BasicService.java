package service;

import com.github.pagehelper.PageInfo;

import java.util.List;
/**
 * @version 1.0
 * @author: fangyanqing
 * @create: 2020-03-03
 **/

public interface BasicService<T> {
    /**
     * 查询所有角色
     * @return
     */
    List<T> findAll();

    /**
     * 根据ID查询
     * @return
     */
    T findById(Integer id);

    /**
     * 增加角色
     * @param object
     */
    void add(T object);

    /**
     * 修改角色
     * @param object
     */
    void update(T object);

    /**
     * 按id删除
     * @param id
     */
    void delete(Integer id);

    /**
     * 多条件搜索
     * @param object
     * @return
     */
    List<T> findList(T object);

    /**
     * 分页
     * @param page
     * @param size
     * @return
     */
    PageInfo<T> findPage(Integer page, Integer size);


    /**
     * 多条件分页查询
     * @param object
     * @param page
     * @param size
     * @return
     */
    PageInfo<T> findPage(T object, Integer page, Integer size);
}
