package com.example.weather.client;

import com.example.weather.vo.City;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ymbcxb
 * @title
 * @Package com.example.weather.client
 * @date 2019/8/11 16:50
 */
@Component
public class CityDataClientHystrix implements CityDataClient {
    @Override
    public List<City> listCity() throws Exception {
        return null;
    }
}
