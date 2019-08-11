package com.example.demo.controller;

import com.example.demo.service.WeatherService;
import com.example.demo.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ymbcxb
 * @title
 * @Package com.example.demo.controller
 * @date 2019/8/4 9:23
 */
@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;
    @RequestMapping("/cityId/{cityId}")
    public WeatherResponse getWeatherByCityId(@PathVariable("cityId") String cityId){
        return weatherService.getDataByCityId(cityId);
    }

    @RequestMapping("/cityName/{cityName}")
    public WeatherResponse getWeatherByCityName(@PathVariable("cityName") String cityName){
        return weatherService.getDataByCityName(cityName);
    }
}
