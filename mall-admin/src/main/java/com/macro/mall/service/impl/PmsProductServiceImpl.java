package com.macro.mall.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.github.pagehelper.PageHelper;
import com.macro.mall.dao.PmsProductDao;
import com.macro.mall.dao.PmsProductVertifyRecordDao;
import com.macro.mall.domain.PmsProductInfo;
import com.macro.mall.dto.PmsProductParam;
import com.macro.mall.dto.PmsProductQueryParam;
import com.macro.mall.example.PmsProductExample;
import com.macro.mall.example.PmsProductSkuExample;
import com.macro.mall.mapper.PmsProductMapper;
import com.macro.mall.mapper.PmsProductSkuMapper;
import com.macro.mall.mapper.YxxProductChargeStandardMapper;
import com.macro.mall.model.PmsProduct;
import com.macro.mall.model.PmsProductSku;
import com.macro.mall.model.PmsProductVertifyRecord;
import com.macro.mall.model.YxxProductChargeStandard;
import com.macro.mall.service.PmsProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 商品管理Service实现类
 *
 * @author macro
 * @date 2018/4/26
 */
@Slf4j
@Service
@AllArgsConstructor
public class PmsProductServiceImpl implements PmsProductService {
    private final PmsProductMapper productMapper;
    private final PmsProductSkuMapper productSkuMapper;
    private final PmsProductDao productDao;
    private final YxxProductChargeStandardMapper standardMapper;

    @Override
    public int create(PmsProductParam productParam) {
        //创建商品
        productParam.setId(null);
        if (productParam.getChargeStandardId() != null) {
            YxxProductChargeStandard standard = standardMapper.selectByPrimaryKey(productParam.getChargeStandardId());
            if (standard != null) {
                productParam.setChargeStandardJson(standard.getContentJson());
            }
        }
        productParam.setCreateTime(new Date());
        productParam.setUpdateTime(new Date());
        productMapper.insertSelective(productParam);
        //根据促销类型设置价格：会员价格、阶梯价格、满减价格
        Long productId = productParam.getId();
        //处理sku的编码
        handleSkuStockCode(productParam.getProductSkuList(), productId);
        //添加sku库存信息
        return productSkuMapper.batchInsert(productParam.getProductSkuList());
    }

    /**
     * 生产SKU编码
     *
     * @param skuStockList SKU规格列表
     * @param productId    商品ID
     */
    private void handleSkuStockCode(List<PmsProductSku> skuStockList, Long productId) {
        if (CollectionUtils.isEmpty(skuStockList)) {
            return;
        }
        int i = 0;
        for (PmsProductSku skuStock : skuStockList) {
            skuStock.setProductId(productId);
            if (StringUtils.isEmpty(skuStock.getSkuCode())) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                //日期
                String sb = sdf.format(new Date()) +
                        //四位商品id
                        String.format("%04d", productId) +
                        //三位索引id
                        String.format("%03d", i + 1);
                skuStock.setSkuCode(sb);
                i++;
            }
        }
    }

    @Override
    public int update(Long id, PmsProductParam productParam) {
        int count;
        //更新商品信息
        productParam.setId(id);
        productParam.setUpdateTime(new Date());
        if (productParam.getChargeStandardId() != null) {
            YxxProductChargeStandard standard = standardMapper.selectByPrimaryKey(productParam.getChargeStandardId());
            if (standard != null) {
                productParam.setChargeStandardJson(standard.getContentJson());
            }
        }
        productMapper.updateByPrimaryKeySelective(productParam);
        //修改sku库存信息
        handleUpdateSkuStockList(id, productParam);
        count = 1;
        return count;
    }

    private void handleUpdateSkuStockList(Long id, PmsProductParam productParam) {
        //当前的sku信息
        List<PmsProductSku> currSkuList = productParam.getProductSkuList();
        //当前没有sku直接删除
        if (CollUtil.isEmpty(currSkuList)) {
            productSkuMapper.deleteByExample(new PmsProductSkuExample().createCriteria().andProductIdEqualTo(id).example());
            return;
        }
        //获取初始sku信息
        List<PmsProductSku> oriStuList = productSkuMapper.selectByExample(new PmsProductSkuExample().createCriteria().andProductIdEqualTo(id).example());
        //获取新增sku信息
        List<PmsProductSku> insertSkuList = currSkuList.stream().filter(item -> item.getId() == null).collect(Collectors.toList());
        //获取需要更新的sku信息
        List<PmsProductSku> updateSkuList = currSkuList.stream().filter(item -> item.getId() != null).collect(Collectors.toList());
        List<Long> updateSkuIds = updateSkuList.stream().map(PmsProductSku::getId).collect(Collectors.toList());
        //获取需要删除的sku信息
        List<PmsProductSku> removeSkuList = oriStuList.stream().filter(item -> !updateSkuIds.contains(item.getId())).collect(Collectors.toList());
        handleSkuStockCode(insertSkuList, id);
        handleSkuStockCode(updateSkuList, id);
        //新增sku
        if (CollUtil.isNotEmpty(insertSkuList)) {
            productSkuMapper.batchInsert(insertSkuList);
        }
        //删除sku
        if (CollUtil.isNotEmpty(removeSkuList)) {
            List<Long> removeSkuIds = removeSkuList.stream().map(PmsProductSku::getId).collect(Collectors.toList());
            PmsProductSkuExample removeExample = new PmsProductSkuExample();
            removeExample.createCriteria().andIdIn(removeSkuIds);
            productSkuMapper.deleteByExample(removeExample);
        }
        //修改sku
        if (CollUtil.isNotEmpty(updateSkuList)) {
            for (PmsProductSku pmsSkuStock : updateSkuList) {
                productSkuMapper.updateByPrimaryKeySelective(pmsSkuStock);
            }
        }

    }

    @Override
    public List<PmsProduct> list(PmsProductQueryParam productQueryParam, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        PmsProductExample productExample = new PmsProductExample();
        PmsProductExample.Criteria criteria = productExample.createCriteria();
        criteria.andDeleteStatusEqualTo(0);
        if (!StringUtils.isEmpty(productQueryParam.getKeyword())) {
            criteria.andNameLike("%" + productQueryParam.getKeyword() + "%");
        }
        if (!StringUtils.isEmpty(productQueryParam.getProductSn())) {
            criteria.andProductSnEqualTo(productQueryParam.getProductSn());
        }

        if (productQueryParam.getProductCategoryId() != null) {
            criteria.andProductCategoryIdEqualTo(productQueryParam.getProductCategoryId());
        }
        return productMapper.selectByExample(productExample);
    }

    @Override
    public List<PmsProductInfo> page(PmsProductQueryParam param, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return productDao.getPmsProductInfoList(param);
    }

    @Override
    public Map<String, Object> detail(Long id) {
        Map<String, Object> map = new HashMap<>(2);
        //获取商品信息
        PmsProduct product = productMapper.selectByPrimaryKey(id);
        //获取商品SKU库存信息
        List<PmsProductSku> skuList = productSkuMapper.selectByExample(new PmsProductSkuExample().createCriteria().andProductIdEqualTo(id).example());
        map.put("product", product);
        map.put("skuList", skuList);
        return map;
    }

    @Override
    public int updatePublishStatus(List<Long> ids, Integer publishStatus) {
        PmsProduct record = new PmsProduct();
        record.setPublishStatus(publishStatus);
        PmsProductExample example = new PmsProductExample();
        example.createCriteria().andIdIn(ids);
        return productMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateRecommendStatus(List<Long> ids, Integer recommendStatus) {
        PmsProduct record = new PmsProduct();
        record.setRecommendStatus(recommendStatus);
        PmsProductExample example = new PmsProductExample();
        example.createCriteria().andIdIn(ids);
        return productMapper.updateByExampleSelective(record, example, PmsProduct.Column.recommendStatus);
    }

    @Override
    public int updateDeleteStatus(List<Long> ids, Integer deleteStatus) {
        PmsProduct record = new PmsProduct();
        record.setDeleteStatus(deleteStatus);
        PmsProductExample example = new PmsProductExample();
        example.createCriteria().andIdIn(ids);
        return productMapper.updateByExampleSelective(record, example);
    }

    @Override
    public List<PmsProduct> list(String keyword) {
        PmsProductExample productExample = new PmsProductExample();
        PmsProductExample.Criteria criteria = productExample.createCriteria();
        criteria.andDeleteStatusEqualTo(0);
        if (!StringUtils.isEmpty(keyword)) {
            criteria.andNameLike("%" + keyword + "%");
            productExample.or().andDeleteStatusEqualTo(0).andProductSnLike("%" + keyword + "%");
        }
        return productMapper.selectByExample(productExample);
    }

}
