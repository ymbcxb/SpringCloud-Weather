package com.example.demo.service;

import com.example.demo.pojo.Weather;

/**
 * @author ymbcxb
 * @title
 * @Package com.example.demo.service
 * @date 2019/8/6 17:51
 */
public interface WeatherReportService {
    Weather getDataByCityId(String cityId);
}
