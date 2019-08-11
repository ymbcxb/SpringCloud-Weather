package com.example.demo.service.impl;

import com.example.demo.common.Const;
import com.example.demo.service.WeatherService;
import com.example.demo.vo.WeatherResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author ymbcxb
 * @title
 * @Package com.example.demo.service.impl
 * @date 2019/8/4 9:34
 */
@Service
@Slf4j
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Autowired
    private RestTemplate restTemplate;

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

    @Override
    public void synecDateByCityId(String cityId) {
        String uri = Const.WEATHER_CITYID_URI+cityId;
        this.saveWeatherData(uri);
    }

    private WeatherResponse getWeatherByUri(String uri){
        String strBody = null;
        //先查询缓存
        if(redisTemplate.hasKey(uri)){
            strBody = redisTemplate.opsForValue().get(uri);
            log.info("命中缓存");
        }else{
            //缓存没有则调用服务
            ResponseEntity<String> resp = restTemplate.getForEntity(uri, String.class);
            strBody = null;
            if(200 == resp.getStatusCodeValue()){
                strBody = resp.getBody();
            }
            redisTemplate.opsForValue().set(uri,strBody,24L, TimeUnit.HOURS);
            log.info("没有命中缓存");
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

    /**
     * 把天气数据放入redis
     * @param uri
     */
    private void saveWeatherData(String uri){
        String strBody = null;
        ResponseEntity<String> resp = restTemplate.getForEntity(uri, String.class);
        strBody = null;
        if(200 == resp.getStatusCodeValue()){
            strBody = resp.getBody();
        }
        redisTemplate.opsForValue().set(uri,strBody,24L, TimeUnit.HOURS);
    }
}
