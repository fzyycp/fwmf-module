package cn.faury.fwmf.module.service.common.service;


import cn.faury.fdk.common.db.CrudBaseService;
import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fdk.common.db.PageParam;
import cn.faury.fdk.common.db.PrimaryKeyEnableBean;
import cn.faury.fdk.mybatis.dao.CommonDao;

import java.util.Map;

public abstract class CrudBaseServiceImpl<T extends PrimaryKeyEnableBean<P>, P> implements CrudBaseService<T, P> {
    /**
     * 数据库操作器
     */
    protected CommonDao commonDao;
    protected Class mapper;

    public CrudBaseServiceImpl(CommonDao commonDao, Class mapper) {
        this.commonDao = commonDao;
        this.mapper = mapper;
    }

    @Override
    public P insert(final T bean) {
        String state = this.mapper.getName() + ".insertSelective";
        this.commonDao.insert(state, bean);
        return bean.getPrimaryKey();
    }

    @Override
    public int update(final T bean) {
        String state = this.mapper.getName() + ".updateByPrimaryKeySelective";
        return this.commonDao.update(state, bean);
    }

    @Override
    public int delete(final T bean) {
        return this.deleteById(bean.getPrimaryKey());
    }

    @Override
    public int deleteById(final P primaryKey) {
        String state = this.mapper.getName() + ".deleteByPrimaryKey";
        return this.commonDao.delete(state, primaryKey);
    }

    @Override
    public T getBeanById(final P primaryKey) {
        String state = this.mapper.getName() + ".selectByPrimaryKey";
        return this.commonDao.selectOne(state, primaryKey);
    }

    @Override
    public PageInfo<T> search(final Map<String, Object> param) {
        String state = this.mapper.getName() + ".search";
        return this.commonDao.selectPage(state, param, PageParam.buildDefaultIns(param));
    }
}
