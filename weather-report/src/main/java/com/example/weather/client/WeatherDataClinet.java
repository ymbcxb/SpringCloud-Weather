package com.example.weather.client;

import com.example.weather.vo.City;
import com.example.weather.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author ymbcxb
 * @title
 * @Package com.example.weather.client
 * @date 2019/8/8 10:18
 */
@FeignClient(name = "weather-zuul",fallback = WeatherDataClinetHystrix.class)
public interface WeatherDataClinet {


    /**
     * 获取城市列表
     * @return
     * @throws Exception
     */
    @GetMapping("/city/cities")
    List<City> listCity() throws Exception;
    /**
     * 更具Id获取天气
     * @param cityId
     * @return
     */
    @GetMapping("/data/weather/cityId/{cityId}")
    WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId);
}
