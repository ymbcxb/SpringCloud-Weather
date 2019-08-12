package com.example.weather.client;

import org.springframework.stereotype.Component;

/**
 * @author ymbcxb
 * @title
 * @Package com.example.weather.client
 * @date 2019/8/11 18:40
 */
@Component
public class WeatherCollectionClientHystrix implements WeatherCollectionClient {
    @Override
    public String collection(String uri) {
        return "服务中断";
    }
}
