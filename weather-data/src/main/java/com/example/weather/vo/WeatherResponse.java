package com.example.weather.vo;

import com.example.weather.pojo.Weather;
import lombok.Data;

import java.io.Serializable;

/**
 * @author ymbcxb
 * @title
 * @Package com.example.weather.vo
 * @date 2019/8/6 17:14
 */
@Data
public class WeatherResponse implements Serializable {

    private static final long serialVersionUID = 1L;
    private Weather data;
    private Integer status;
    private String desc;
}

