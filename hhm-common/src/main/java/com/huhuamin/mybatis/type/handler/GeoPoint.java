package com.huhuamin.mybatis.type.handler;

import java.math.BigDecimal;

/**
 * @Auther: Huhuamin
 * @Date: 2020/2/28 14:25
 * @Description:
 */
public class GeoPoint {
    public GeoPoint(BigDecimal lng, BigDecimal lat) {
        this.lng = lng;
        this.lat = lat;
    }

    /* 经度 */
    private BigDecimal lng;
    /* 纬度 */
    private BigDecimal lat;

    public BigDecimal getLng() {
        return lng;
    }

    public void setLng(BigDecimal lng) {
        this.lng = lng;
    }

    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }
}
