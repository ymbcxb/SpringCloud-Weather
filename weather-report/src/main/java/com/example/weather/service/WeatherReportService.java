package com.example.weather.service;

import com.example.weather.pojo.Weather;

/**
 * @author ymbcxb
 * @title
 * @Package com.example.weather.service
 * @date 2019/8/6 19:47
 */
public interface WeatherReportService {
    Weather getDataByCityId(String cityId);
}
