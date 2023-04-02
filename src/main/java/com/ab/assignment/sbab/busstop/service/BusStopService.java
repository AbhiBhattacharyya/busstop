package com.ab.assignment.sbab.busstop.service;

import com.ab.assignment.sbab.busstop.model.line.LineResponseOfPwsResult;
import com.ab.assignment.sbab.busstop.model.stop.StopResponseOfPwsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class BusStopService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${key}")
    private String key;


    public CompletableFuture<LineResponseOfPwsResult> getAllLines() {

        CompletableFuture<LineResponseOfPwsResult> lineResponseOfPwsResult = CompletableFuture.supplyAsync(() -> {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Accept-Encoding", "gzip, deflate");
            HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
            String url = "https://api.sl.se/api2/LineData.json?model=JourneyPatternPointOnLine&key=" + key + "&DefaultTransportModeCode=BUS";
            ResponseEntity<LineResponseOfPwsResult> responseOfPwsResult = restTemplate.exchange(url, HttpMethod.GET, entity, LineResponseOfPwsResult.class);
            return responseOfPwsResult.getBody();
        });

        return lineResponseOfPwsResult;
    }


    public CompletableFuture<StopResponseOfPwsResult> getAllStops() {

        CompletableFuture<StopResponseOfPwsResult> stopResponseOfPwsResult = CompletableFuture.supplyAsync(() -> {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Accept-Encoding", "gzip, deflate");
            HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
            String url = "https://api.sl.se/api2/LineData.json?model=stop&key=" + key + "&DefaultTransportModeCode=BUS";
            ResponseEntity<StopResponseOfPwsResult> responseOfPwsResult = restTemplate.exchange(url, HttpMethod.GET, entity, StopResponseOfPwsResult.class);
            return responseOfPwsResult.getBody();
        });

        return stopResponseOfPwsResult;
    }


}
