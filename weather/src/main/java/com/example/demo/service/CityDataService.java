package com.example.demo.service;

import com.example.demo.vo.City;

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
