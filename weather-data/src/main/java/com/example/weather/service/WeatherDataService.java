package com.example.weather.service;

import com.example.weather.vo.WeatherResponse;

/**
 * @author ymbcxb
 * @title
 * @Package com.example.weather.service
 * @date 2019/8/6 16:41
 */
public interface WeatherDataService {
    WeatherResponse getDataByCityId(String cityId);
    WeatherResponse getDataByCityName(String cityName);
}
