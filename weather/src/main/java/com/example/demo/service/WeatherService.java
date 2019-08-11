package com.example.demo.service;

import com.example.demo.vo.WeatherResponse;

/**
 * @author ymbcxb
 * @title
 * @Package com.example.demo.service
 * @date 2019/8/4 9:34
 */
public interface WeatherService {
    WeatherResponse getDataByCityId(String cityId);
    WeatherResponse getDataByCityName(String cityName);
    void synecDateByCityId(String cityId);
}
