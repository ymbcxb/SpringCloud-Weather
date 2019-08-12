package com.example.weather.controller;

import com.example.weather.service.CityDataService;
import com.example.weather.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ymbcxb
 * @title
 * @Package com.example.weather.controller
 * @date 2019/8/6 20:04
 */
@RestController
@RequestMapping("cities")
public class CityController {

    @Autowired
    private CityDataService cityDataService;
    @GetMapping
    public List<City> listCity() throws Exception {
        return cityDataService.listCity();
    }
}
