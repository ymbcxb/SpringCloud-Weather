package com.example.weather.service;

import com.example.weather.vo.City;

import java.util.List;

/**
 * @author ymbcxb
 * @title
 * @Package com.example.demo.service
 * @date 2019/8/6 13:43
 */
public interface CityDataService {
    List<City> listCity() throws Exception;
}
