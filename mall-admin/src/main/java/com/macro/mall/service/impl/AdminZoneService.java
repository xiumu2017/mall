package com.macro.mall.service.impl;

import com.macro.mall.mapper.YxxZoneMapper;
import com.macro.mall.model.YxxZone;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Paradise
 */
@Service
@AllArgsConstructor
public class AdminZoneService {
    private final YxxZoneMapper zoneMapper;

    public int del(Long zoneId) {
        YxxZone zone = YxxZone.builder().id(zoneId).updateTime(new Date()).status(-1).build();
        return zoneMapper.updateByPrimaryKeySelective(zone, YxxZone.Column.updateTime, YxxZone.Column.status);
    }

    public int enableSwitch(Long zoneId) {
        YxxZone zone = zoneMapper.selectByPrimaryKey(zoneId);
        if (zone.getEnable() == 1) {
            zone.setEnable(0);
        } else {
            zone.setEnable(1);
        }
        zone.setUpdateTime(new Date());
        return zoneMapper.updateByPrimaryKeySelective(zone, YxxZone.Column.updateTime, YxxZone.Column.enable);
    }
}
