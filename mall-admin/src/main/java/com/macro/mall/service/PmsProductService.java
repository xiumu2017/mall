package com.macro.mall.service;

import com.macro.mall.domain.PmsProductInfo;
import com.macro.mall.dto.PmsProductParam;
import com.macro.mall.dto.PmsProductQueryParam;
import com.macro.mall.model.PmsProduct;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 商品管理Service
 * Created by macro on 2018/4/26.
 */
public interface PmsProductService {
    /**
     * 创建商品
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    int create(PmsProductParam productParam);

    /**
     * 更新商品
     */
    @Transactional
    int update(Long id, PmsProductParam productParam);

    /**
     * 分页查询商品
     */
    List<PmsProduct> list(PmsProductQueryParam productQueryParam, Integer pageSize, Integer pageNum);

    /**
     * 批量修改商品上架状态
     */
    int updatePublishStatus(List<Long> ids, Integer publishStatus);

    /**
     * 批量修改商品推荐状态
     */
    int updateRecommendStatus(List<Long> ids, Integer recommendStatus);

    /**
     * 批量删除商品
     */
    int updateDeleteStatus(List<Long> ids, Integer deleteStatus);

    /**
     * 根据商品名称或者货号模糊查询
     */
    List<PmsProduct> list(String keyword);


    /**
     * 分页查询
     *
     * @param param    查询参数
     * @param pageSize 分页参数
     * @param pageNum  分页参数
     * @return {@link PmsProductInfo}
     */
    List<PmsProductInfo> page(PmsProductQueryParam param, Integer pageSize, Integer pageNum);

    /**
     * 详情
     *
     * @param id 服务品类ID
     * @return {@link PmsProduct}
     */
    Map<String, Object> detail(Long id);
}
