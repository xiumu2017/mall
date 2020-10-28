package com.macro.mall.domain;

import com.macro.mall.model.YxxZoneSkilledProduct;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Paradise
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ZoneSkilledProductInfo extends YxxZoneSkilledProduct {
    private String productName;
}
