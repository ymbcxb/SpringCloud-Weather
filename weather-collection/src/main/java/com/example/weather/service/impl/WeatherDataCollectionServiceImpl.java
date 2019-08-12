package com.example.weather.service.impl;

import com.example.weather.common.Const;
import com.example.weather.service.WeatherDataCollectionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author ymbcxb
 * @title
 * @Package com.example.weather.service.impl
 * @date 2019/8/6 15:58
 * @Description:数据采集
 */
@Slf4j
@Service
public class WeatherDataCollectionServiceImpl implements WeatherDataCollectionService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Override
    public void synecDateByCityId(String cityId) {
        String uri = Const.WEATHER_CITYID_URI+cityId;
        this.saveWeatherData(uri);
    }

    @Override
    public String saveWeatherData(String uri){
        log.info("uri: {}",uri);
        String strBody = null;
        ResponseEntity<String> resp = restTemplate.getForEntity(uri, String.class);
        strBody = null;
        if(200 == resp.getStatusCodeValue()){
            strBody = resp.getBody();
        }
        redisTemplate.opsForValue().set(uri,strBody,24L, TimeUnit.HOURS);
        return strBody;
    }
}
