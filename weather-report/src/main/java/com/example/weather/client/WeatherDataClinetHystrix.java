package com.example.weather.client;

import com.example.weather.vo.City;
import com.example.weather.vo.WeatherResponse;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * @author ymbcxb
 * @title
 * @Package com.example.weather.client
 * @date 2019/8/11 15:34
 */
@Component
public class WeatherDataClinetHystrix implements WeatherDataClinet {
    @Override
    public List<City> listCity() throws Exception {
        return Collections.EMPTY_LIST;
    }

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        return null;
    }
}
