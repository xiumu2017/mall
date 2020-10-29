package com.macro.mall.portal.service.impl;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.macro.mall.domain.PmsProductInfo;
import com.macro.mall.example.PmsProductCategoryExample;
import com.macro.mall.example.*;
import com.macro.mall.mapper.*;
import com.macro.mall.model.*;
import com.macro.mall.portal.dao.PortalProductDao;
import com.macro.mall.portal.domain.PmsProductCategoryNode;
import com.macro.mall.portal.domain.PmsProductDetail;
import com.macro.mall.portal.service.PmsPortalProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    private final PmsProductSkuMapper productSkuMapper;
    private final PortalProductDao portalProductDao;
    private final YxxProductCommentLabelMapper commentLabelMapper;
    private final YxxHomeQaMapper homeQaMapper;
    private final YxxProductQaMapper productQaMapper;

    @Override
    public List<PmsProduct> search(String keyword, Long productCategoryId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PmsProductExample example = new PmsProductExample();
        PmsProductExample.Criteria criteria = example.createCriteria();
        criteria.andDeleteStatusEqualTo(0);
        if (StrUtil.isNotEmpty(keyword)) {
            criteria.andNameLike("%" + keyword + "%");
        }
        if (productCategoryId != null) {
            criteria.andProductCategoryIdEqualTo(productCategoryId);
        }
        return productMapper.selectByExample(example.orderBy(PmsProduct.Column.sort.desc()));
    }

    @Override
    public List<PmsProductCategoryNode> categoryTreeList(Long regionId) {
        PmsProductCategoryExample example = new PmsProductCategoryExample();
        if (regionId != null) {
            example.createCriteria().andRegionIdEqualTo(regionId);
        }
        List<PmsProductCategory> allList = productCategoryMapper.selectByExample(example);
        return allList.stream()
                .filter(item -> item.getParentId().equals(0L))
                .map(item -> covert(item, allList)).collect(Collectors.toList());
    }

    @Override
    public PmsProductDetail detail(Long id) {
        PmsProductDetail result = new PmsProductDetail();
        //获取商品信息
        PmsProduct product = productMapper.selectByPrimaryKey(id);
        result.setProduct(product);
        //获取商品SKU库存信息
        result.setSkuStockList(productSkuMapper.selectByExample(new PmsProductSkuExample().createCriteria().andProductIdEqualTo(id).example()));
        //商品可用优惠券
        result.setCouponList(portalProductDao.getAvailableCouponList(product.getId(), product.getProductCategoryId()));
        // 查询服务品类评价标签信息
        List<YxxProductCommentLabel> commentLabelList = commentLabelMapper.selectByExample(
                new YxxProductCommentLabelExample().createCriteria().andProductIdEqualTo(id).
                        andEnableEqualTo(1).example().orderBy(YxxProductCommentLabel.Column.sort.desc())
        );
        result.setCommentLabelList(commentLabelList);
        // 查询服务品类QA列表
        List<YxxProductQa> productQaList = productQaMapper.selectByExample(new YxxProductQaExample().createCriteria().andProductIdEqualTo(id).example());
        List<Long> ids = new ArrayList<>();
        productQaList.forEach(item -> ids.add(item.getQaId()));
        List<YxxHomeQa> qaList = homeQaMapper.selectByExample(new YxxHomeQaExample().createCriteria().andIdIn(ids).andEnableEqualTo(1)
                .andDeletedEqualTo(0).example().orderBy(YxxHomeQa.Column.orderNum.asc()));
        return result;
    }


    /**
     * 初始对象转化为节点对象
     */
    private PmsProductCategoryNode covert(PmsProductCategory item, List<PmsProductCategory> allList) {
        PmsProductCategoryNode node = new PmsProductCategoryNode();
        BeanUtils.copyProperties(item, node);
        List<PmsProductCategoryNode> children = allList.stream()
                .filter(subItem -> subItem.getParentId().equals(item.getId()))
                .map(subItem -> covert(subItem, allList)).collect(Collectors.toList());
        node.setChildren(children);
        return node;
    }

    /**
     * 推荐商品列表
     *
     * @param regionId 区域ID
     * @return 商品列表
     */
    @Override
    public List<PmsProductInfo> recommendProductList(Long regionId) {
        return portalProductDao.recommendProductList(regionId);
    }
}
