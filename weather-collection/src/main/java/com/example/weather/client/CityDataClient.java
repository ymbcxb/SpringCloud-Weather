package com.example.weather.client;

import com.example.weather.vo.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author ymbcxb
 * @title
 * @Package com.example.weather
 * @date 2019/8/11 16:42
 */
@FeignClient(name = "weather-zuul",fallback = CityDataClientHystrix.class)
public interface CityDataClient {
    /**
     * 获取城市列表
     * @return
     * @throws Exception
     */
    @GetMapping("/city/cities")
    List<City> listCity() throws Exception;
}
