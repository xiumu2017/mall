package com.macro.mall.portal.service.impl;

import com.macro.mall.example.PmsProductCategoryExample;
import com.macro.mall.example.YxxHomeBannerExample;
import com.macro.mall.example.YxxProductCommentLabelExample;
import com.macro.mall.example.YxxRegionExample;
import com.macro.mall.mapper.PmsProductCategoryMapper;
import com.macro.mall.mapper.YxxHomeBannerMapper;
import com.macro.mall.mapper.YxxProductCommentLabelMapper;
import com.macro.mall.mapper.YxxRegionMapper;
import com.macro.mall.model.PmsProductCategory;
import com.macro.mall.model.YxxHomeBanner;
import com.macro.mall.model.YxxProductCommentLabel;
import com.macro.mall.model.YxxRegion;
import com.macro.mall.portal.service.HomeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 首页内容管理Service实现类
 * Created by macro on 2019/1/28.
 *
 * @author Paradise
 */
@Service
@AllArgsConstructor
public class HomeServiceImpl implements HomeService {

    private final PmsProductCategoryMapper productCategoryMapper;
    private final YxxHomeBannerMapper homeBannerMapper;
    private final YxxRegionMapper regionMapper;
    private final YxxProductCommentLabelMapper commentLabelMapper;

    @Override
    public List<YxxHomeBanner> homeBannerList(Long regionId) {
        YxxHomeBannerExample example = new YxxHomeBannerExample();
        example.createCriteria().andDeletedEqualTo(0).andRegionIdEqualTo(regionId);
        return homeBannerMapper.selectByExample(example);
    }


    @Override
    public List<PmsProductCategory> getProductCateList(Long parentId) {
        PmsProductCategoryExample example = new PmsProductCategoryExample();
        example.createCriteria()
                .andShowStatusEqualTo(1)
                .andParentIdEqualTo(parentId);
        example.setOrderByClause("sort desc");
        return productCategoryMapper.selectByExample(example);
    }

    @Override
    public List<YxxRegion> getRegionList() {
        return regionMapper.selectByExample(new YxxRegionExample().createCriteria().andEnableEqualTo(1).example());
    }

    @Override
    public List<YxxProductCommentLabel> getLabelList() {
        return commentLabelMapper.selectByExample(new YxxProductCommentLabelExample().createCriteria()
                .andEnableEqualTo(1).andProductIdIsNull().example()
                .orderBy(YxxProductCommentLabel.Column.sort.desc()));
    }
}
