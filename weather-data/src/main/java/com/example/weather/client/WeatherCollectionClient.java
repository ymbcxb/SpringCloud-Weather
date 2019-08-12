package com.example.weather.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ymbcxb
 * @title
 * @Package com.example.weather
 * @date 2019/8/11 16:55
 */
@FeignClient(name = "weather-zuul",fallback = WeatherCollectionClientHystrix.class)
public interface WeatherCollectionClient {
    @GetMapping("/collection/collection")
    String collection(@RequestParam("uri") String uri);
}
