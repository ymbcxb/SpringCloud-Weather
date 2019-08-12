package com.example.weather.service.impl;

import com.example.weather.client.WeatherCollectionClient;
import com.example.weather.common.Const;
import com.example.weather.service.WeatherDataService;
import com.example.weather.vo.WeatherResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author ymbcxb
 * @title
 * @Package com.example.weather.service.impl
 * @date 2019/8/6 17:13
 */
@Slf4j
@Service
public class WeatherDataServiceImpl implements WeatherDataService {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Autowired
    private WeatherCollectionClient weatherCollectionClient;

    @Override
    public WeatherResponse getDataByCityId(String cityId){
        String uri = Const.WEATHER_CITYID_URI+cityId;
        WeatherResponse weather = getWeatherByUri(uri);
        return weather;
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName){
        String uri = Const.WEATHER_CITYNAME_URI+cityName;
        WeatherResponse weather = getWeatherByUri(uri);
        return weather;
    }

    private WeatherResponse getWeatherByUri(String uri){
        String strBody = null;
        //先查询缓存
        if(redisTemplate.hasKey(uri)){
            strBody = redisTemplate.opsForValue().get(uri);
            log.info("命中缓存");
        }else{
            log.error("不命中缓存");
            strBody = weatherCollectionClient.collection(uri);
            log.info("strBody: {}",strBody);
        }
        ObjectMapper mapper = new ObjectMapper();
        WeatherResponse weather = null;
        try {
            weather = mapper.readValue(strBody, WeatherResponse.class);
        } catch (IOException e) {
            log.error("获取天气失败:{}",e.getMessage());
        }
        return weather;
    }
}
