package com.example.weather.controller;

import com.example.weather.service.WeatherDataCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ymbcxb
 * @title
 * @Package com.example.weather.controller
 * @date 2019/8/11 16:58
 */
@RestController
public class WeatherCollectionController {

    @Autowired
    private WeatherDataCollectionService weatherDataCollectionService;

    @RequestMapping("/collection")
    public String collection(String uri){
        return weatherDataCollectionService.saveWeatherData(uri);
    }
}
