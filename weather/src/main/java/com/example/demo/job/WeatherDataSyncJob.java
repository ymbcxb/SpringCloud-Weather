package com.example.demo.job;

import com.example.demo.service.CityDataService;
import com.example.demo.service.WeatherService;
import com.example.demo.vo.City;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

/**
 * @author ymbcxb
 * @title
 * @Package com.example.demo.job
 * @date 2019/8/6 10:31
 */
@Slf4j
public class WeatherDataSyncJob extends QuartzJobBean {

    @Autowired
    private CityDataService cityDataService;

    @Autowired
    private WeatherService weatherService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        List<City> cityList = null;
        try {
            cityList = cityDataService.listCity();
        } catch (Exception e) {
            log.error("获取城市列表失败:{}",e.getMessage());
        }
        for(City city : cityList){
            String cityId = city.getCityId();
            log.info("Weather CityId: {}",cityId);
            weatherService.synecDateByCityId(cityId);
        }
    }
}
