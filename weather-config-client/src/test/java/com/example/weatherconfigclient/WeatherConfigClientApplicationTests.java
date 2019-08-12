package com.example.weatherconfigclient;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherConfigClientApplicationTests {

    @Value("${auther}")
    private String auther;

    @Test
    public void contextLoads() {
        log.info(auther);

    }

}
