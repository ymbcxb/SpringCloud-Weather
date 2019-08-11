package com.example.demo.service.impl;

import com.example.demo.pojo.Weather;
import com.example.demo.service.WeatherReportService;
import com.example.demo.service.WeatherService;
import com.example.demo.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ymbcxb
 * @title
 * @Package com.example.demo.service.impl
 * @date 2019/8/6 17:51
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {
    @Autowired
    private WeatherService weatherDataService;

    @Override
    public Weather getDataByCityId(String cityId) {
        WeatherResponse resp = weatherDataService.getDataByCityId(cityId);
        return resp.getData();
    }

}
