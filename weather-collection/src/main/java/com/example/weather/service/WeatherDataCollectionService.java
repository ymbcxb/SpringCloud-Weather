package com.example.weather.service;

/**
 * @author ymbcxb
 * @title
 * @Package com.example.weather.service
 * @date 2019/8/6 15:58
 */
public interface WeatherDataCollectionService {
    /**
     *  根据城市天气同步Id
     */
    void synecDateByCityId(String cityId);

    /**
     * 保存城市天气uri
     * @param uri
     */
    String saveWeatherData(String uri);
}
