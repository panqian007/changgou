package com.changgou.service.impl;/**
 * @Author panqian
 * @Date 2020/9/1 9:49
 * @Version 1.0.0
 */

import com.changgou.dao.BrandMapper;
import com.changgou.goods.pojo.Brand;
import com.changgou.service.BrandService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author panqian
 * @Date 2020/9/1 9:49
 * @Version 1.0.0
 */
@Service
public class BrandServiceimpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;

    /**
     * 分页条件查询
     * @param brand 条件
     * @param page 当前页
     * @param size 每页大小
     * @return
     */
    @Override
    public PageInfo<Brand> findPage(Brand brand, Integer page, Integer size) {
        PageHelper.startPage(page,size);
        Example example = createExample(brand);
        List<Brand> brands = brandMapper.selectByExample(example);
        return new PageInfo<Brand>(brands);
    }

    /**
     * 分页查询
     * @param page 当前页
     * @param size 每页大小
     * @return
     */
    @Override
    public PageInfo<Brand> findPage(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        List<Brand> brands = brandMapper.selectAll();
        return new PageInfo<Brand>(brands);
    }

    /**
     * 多条件查询
     * @param brand
     * @return
     */
    @Override
    public List<Brand> findList(Brand brand) {
    Example example = createExample(brand);
        return brandMapper.selectByExample(example);
    }

    /**
     * 条件构造抽离
     * @param brand
     * @return
     */
    public Example createExample(Brand brand){
        Example example = new Example(Brand.class);
        Example.Criteria criteria  =example.createCriteria();
        if(brand!=null){
            //根据name模糊查询
            if(!StringUtils.isEmpty(brand.getName())){
                criteria.andLike("name","%"+brand.getName()+"%");
            }
            //根据首字母查询
            if(!StringUtils.isEmpty(brand.getLetter())){
                criteria.andEqualTo("letter",brand.getLetter());
            }
        }
        return example;
    }

    /**
     * 根据id删除
     * @param id
     */
    @Override
    public void delete(Integer id) {
        brandMapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据id修改信息
     * @param brand
     */
    @Override
    public void update( Brand brand) {
        brandMapper.updateByPrimaryKeySelective(brand);
    }

    /**
     * 添加
     * @param brand
     */
    @Override
    public void add(Brand brand) {
        brandMapper.insertSelective(brand);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public Brand findById(Integer id) {

        return brandMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询所有
     * @return
     */
    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }
}
