package com.example.weather.service.impl;

import com.example.weather.service.CityDataService;
import com.example.weather.util.XmlBuilder;
import com.example.weather.vo.City;
import com.example.weather.vo.CityList;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @author ymbcxb
 * @title
 * @Package com.example.demo.service.impl
 * @date 2019/8/6 13:44
 */
@Service
public class CityDataServiceImpl implements CityDataService {
    @Override
    public List<City> listCity() throws Exception {
        //读取XML文件
        Resource resource = new ClassPathResource("citylist.xml");
        BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(),"utf-8"));
        StringBuffer buffer = new StringBuffer();
        String line = "";
        while((line = br.readLine()) != null){
            buffer.append(line);
        }
        br.close();
        //XML转为Java对象
        CityList cityList = (CityList) XmlBuilder.xmlStrToObject(CityList.class,buffer.toString());
        return cityList.getCityList();
    }
}
