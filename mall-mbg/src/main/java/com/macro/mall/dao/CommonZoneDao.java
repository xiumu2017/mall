package com.macro.mall.dao;

import com.macro.mall.domain.ZoneSkilledProductInfo;
import com.macro.mall.domain.ZoneWorkerInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单自定义查询Dao
 *
 * @author Paradise
 * @date 2020-10-10
 */
public interface CommonZoneDao {

    /**
     * 查询区域服务中心下的维修工
     *
     * @param zoneId  区域服务中心ID
     * @param keyword 关键词搜索
     * @return {@link ZoneWorkerInfo}
     */
    List<ZoneWorkerInfo> queryWorkersByZoneId(@Param("zoneId") Long zoneId, @Param("keyword") String keyword);

    /**
     * 查询区域服务中心擅长品类列表
     *
     * @param zoneId 区域服务中心ID
     * @return 擅长品类列表
     */
    List<ZoneSkilledProductInfo> querySkilledProInfoList(Long zoneId);
}
