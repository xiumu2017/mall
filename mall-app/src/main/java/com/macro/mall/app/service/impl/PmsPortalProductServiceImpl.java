package com.macro.mall.app.service.impl;

import com.macro.mall.app.domain.AppProductInfo;
import com.macro.mall.app.domain.PmsProductNode;
import com.macro.mall.app.service.PmsPortalProductService;
import com.macro.mall.example.PmsProductCategoryExample;
import com.macro.mall.example.PmsProductExample;
import com.macro.mall.example.YxxHomeCostExample;
import com.macro.mall.mapper.PmsProductCategoryMapper;
import com.macro.mall.mapper.PmsProductMapper;
import com.macro.mall.mapper.YxxHomeCostMapper;
import com.macro.mall.model.PmsProduct;
import com.macro.mall.model.PmsProductCategory;
import com.macro.mall.model.YxxHomeCost;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 前台订单管理Service实现类
 *
 * @author macro
 * @date 2020/4/6
 */
@Service
@AllArgsConstructor
public class PmsPortalProductServiceImpl implements PmsPortalProductService {
    private final PmsProductMapper productMapper;
    private final PmsProductCategoryMapper productCategoryMapper;
    private final YxxHomeCostMapper homeCostMapper;

    @Override
    public List<PmsProductNode> categoryTreeList(Long regionId) {
        PmsProductCategoryExample example = new PmsProductCategoryExample();
        PmsProductCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdNotEqualTo(0L);
        if (regionId != null) {
            criteria.andRegionIdEqualTo(regionId);
        }
        List<PmsProductCategory> allList = productCategoryMapper.selectByExample(example);
        List<PmsProductNode> nodeList = new ArrayList<>();
        allList.forEach(pmsProductCategory -> {
            List<PmsProduct> products = productMapper.selectByExampleSelective(new PmsProductExample().createCriteria()
                    .andProductCategoryIdEqualTo(pmsProductCategory.getId()).example(), PmsProduct.Column.name, PmsProduct.Column.id);
            PmsProductNode node = new PmsProductNode(products);
            node.setName(pmsProductCategory.getName());
            node.setId(pmsProductCategory.getId());
            nodeList.add(node);
        });
        return nodeList;
    }

    @Override
    public PmsProduct productInfo(Long id) {
        AppProductInfo appProductInfo = new AppProductInfo();
        PmsProduct product = productMapper.selectByPrimaryKeySelective(id, PmsProduct.Column.excludes(PmsProduct.Column.detailHtml));
        BeanUtils.copyProperties(product, appProductInfo);
        String costs = product.getCommonCost();
        if (!StringUtils.isEmpty(costs)) {
            String[] arr = costs.split(",");
            List<Long> ids = new ArrayList<>();
            for (String s : arr) {
                ids.add(Long.parseLong(s));
            }
            List<YxxHomeCost> costList = homeCostMapper.selectByExample(
                    new YxxHomeCostExample().createCriteria().andIdIn(ids).example()
            );
            appProductInfo.setCommonCostList(costList);
        } else {
            appProductInfo.setCommonCostList(new ArrayList<>());
        }
        return appProductInfo;
    }

    @Override
    public List<PmsProduct> productInfoList(Long regionId) {
        return productMapper.selectByExampleSelective(new PmsProductExample().createCriteria().andDeleteStatusNotEqualTo(1)
                        .when(regionId != null, criteria -> criteria.andRegionIdEqualTo(regionId)).example().orderBy(PmsProduct.Column.sort.desc()),
                PmsProduct.Column.excludes(
                        PmsProduct.Column.detailHtml
                ));
    }
}
