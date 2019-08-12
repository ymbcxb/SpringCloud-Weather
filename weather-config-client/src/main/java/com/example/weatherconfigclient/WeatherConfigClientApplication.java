package com.example.weatherconfigclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient

@SpringBootApplication
public class WeatherConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherConfigClientApplication.class, args);
    }

}
