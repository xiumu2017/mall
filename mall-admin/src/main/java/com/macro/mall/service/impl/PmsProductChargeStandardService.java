package com.macro.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.common.exception.Asserts;
import com.macro.mall.example.PmsProductExample;
import com.macro.mall.example.YxxProductChargeStandardExample;
import com.macro.mall.mapper.PmsProductMapper;
import com.macro.mall.mapper.YxxProductChargeStandardMapper;
import com.macro.mall.model.PmsProduct;
import com.macro.mall.model.YxxProductChargeStandard;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @author Paradise
 */
@Service
public class PmsProductChargeStandardService {
    private final YxxProductChargeStandardMapper chargeStandardMapper;
    private final PmsProductMapper productMapper;

    public PmsProductChargeStandardService(YxxProductChargeStandardMapper chargeStandardMapper, PmsProductMapper productMapper) {
        this.chargeStandardMapper = chargeStandardMapper;
        this.productMapper = productMapper;
    }

    public YxxProductChargeStandard create(YxxProductChargeStandard chargeStandard) {
        long count = chargeStandardMapper.countByExample(new YxxProductChargeStandardExample().createCriteria()
                .andNameEqualTo(chargeStandard.getName()).andDeletedEqualTo(0).example());
        Asserts.pvIsTrue(count < 1, "收费标准名称已存在");
        chargeStandard.setCreateTime(new Date());
        chargeStandard.setDeleted(0);
        chargeStandardMapper.insert(chargeStandard);
        return chargeStandard;
    }

    public int update(YxxProductChargeStandard chargeStandard) {
        // 同步更新 服务品类
        PmsProduct product = PmsProduct.builder().chargeStandardJson(chargeStandard.getContentJson()).updateTime(new Date()).build();
        productMapper.updateByExampleSelective(product, new PmsProductExample().createCriteria().andChargeStandardIdEqualTo(chargeStandard.getId()).example(),
                PmsProduct.Column.updateTime, PmsProduct.Column.chargeStandardJson);
        return chargeStandardMapper.updateByPrimaryKeyWithBLOBs(chargeStandard);
    }

    /**
     * 删除
     *
     * @param id 主键
     * @return 删除结果
     */
    public int del(Long id) {
        return chargeStandardMapper.deleteByPrimaryKey(id);
    }

    /**
     * 更新状态
     *
     * @param id     主键
     * @param enable 是否启用
     * @return 更新result
     */
    public int changeStatus(Long id, Integer enable) {
        YxxProductChargeStandard standard = new YxxProductChargeStandard();
        standard.setId(id);
        standard.setEnable(enable);
        return chargeStandardMapper.updateByPrimaryKeySelective(standard);
    }

    /**
     * 分页查询
     *
     * @param name     收费标准名称
     * @param pageNum  pageNum
     * @param pageSize pageSize
     * @param enable   是否启用
     * @return 列表数据
     */
    public List<YxxProductChargeStandard> page(String name, int pageNum, int pageSize, Integer enable) {
        PageHelper.startPage(pageNum, pageSize);
        YxxProductChargeStandardExample example = new YxxProductChargeStandardExample();
        YxxProductChargeStandardExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        if (enable != null) {
            criteria.andEnableEqualTo(enable);
        }
        return chargeStandardMapper.selectByExampleWithBLOBs(example);
    }
}
