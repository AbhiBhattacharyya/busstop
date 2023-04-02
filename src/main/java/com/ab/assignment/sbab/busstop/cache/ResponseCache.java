package com.ab.assignment.sbab.busstop.cache;

import com.ab.assignment.sbab.busstop.model.response.ResponseBusStop;
import com.ab.assignment.sbab.busstop.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.ParseException;

@Configuration
public class ResponseCache {

    @Autowired
    CommonService commonService;

    @Bean("cache")
    public ResponseBusStop getResposeBusStop() throws ParseException {
        return commonService.getFinalResult();
    }
}
