package com.changgou.service;/**
 * @Author panqian
 * @Date 2020/9/1 9:50
 * @Version 1.0.0
 */

import com.changgou.goods.pojo.Brand;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Author panqian
 * @Date 2020/9/1 9:50
 * @Version 1.0.0
 */
public interface BrandService {

    /**
     * 分页条件查询
     * @param brand
     * @param page
     * @param size
     * @return
     */
    PageInfo<Brand> findPage(Brand brand,Integer page,Integer size);
    /**
     * 分页
     * @param page
     * @param size
     * @return
     */
    PageInfo<Brand> findPage(Integer page,Integer size);
    /**
     * 多条件查询
     * @param brand
     * @return
     */
    List<Brand> findList(Brand brand);
    /**
     * 根据id删除
     * @param id
     */
    void delete(Integer id);
    /**
     * 根据id更新信息
     * @param
     * @param brand
     */
    void update(Brand brand);

    /**
     * 添加
     * @param brand
     */
    void add(Brand brand);

    /**
     * 根据id查询
     * @return
     */
    Brand findById(Integer id);

    /**
     * 查询所有
     * @return
     */
    List<Brand> findAll();


}
