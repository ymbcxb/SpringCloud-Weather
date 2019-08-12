package com.example.weather.service.impl;

import com.example.weather.client.WeatherDataClinet;
import com.example.weather.pojo.Weather;
import com.example.weather.service.WeatherReportService;
import com.example.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ymbcxb
 * @title
 * @Package com.example.weather.service.impl
 * @date 2019/8/6 19:48
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {
    @Autowired
    private WeatherDataClinet weatherDataClinet;

    @Override
    public Weather getDataByCityId(String cityId) {
        WeatherResponse resp = weatherDataClinet.getDataByCityId(cityId);
        return resp.getData();
    }
}
