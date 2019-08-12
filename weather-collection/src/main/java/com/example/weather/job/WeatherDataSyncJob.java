package com.example.weather.job;

import com.example.weather.client.CityDataClient;
import com.example.weather.service.WeatherDataCollectionService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author ymbcxb
 * @title
 * @Package com.example.weather.job
 * @date 2019/8/6 16:14
 */
@Slf4j
public class WeatherDataSyncJob extends QuartzJobBean {

    @Autowired
    private WeatherDataCollectionService weatherService;
    @Autowired
    private CityDataClient cityDataClient;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("开始采集");
//        List<City> cityList = null;
//        try {
//            cityList = cityDataClient.listCity();
//        } catch (Exception e) {
//            log.error("获取城市列表失败:{}",e.getMessage());
//        }
//        for(City city : cityList){
//            String cityId = city.getCityId();
//            String cityName = city.getCityName();
//            log.info("Weather C" +
//                    "ityId: {}, CityName: {}",cityId,cityName);
//            weatherService.synecDateByCityId(cityId);
//        }
        log.info("采集结束");
    }
}

