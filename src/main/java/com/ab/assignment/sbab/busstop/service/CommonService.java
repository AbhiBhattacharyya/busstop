package com.ab.assignment.sbab.busstop.service;


import com.ab.assignment.sbab.busstop.model.line.LineResponseOfPwsResult;
import com.ab.assignment.sbab.busstop.model.line.LineResult;
import com.ab.assignment.sbab.busstop.model.response.ResponseBusStop;
import com.ab.assignment.sbab.busstop.model.response.StopsInLine;
import com.ab.assignment.sbab.busstop.model.stop.StopResponseOfPwsResult;
import com.ab.assignment.sbab.busstop.util.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.CompletableFuture;

import static com.ab.assignment.sbab.busstop.util.DataUtil.*;

@Service
public class CommonService {

    @Autowired
    BusStopService busStopService;

    @Autowired
    DataUtil dataUtil;


    public ResponseBusStop getFinalResult() throws ParseException {


        CompletableFuture completableFutureLine = busStopService.getAllLines();
        CompletableFuture completableFutureStop = busStopService.getAllStops();

        List<StopsInLine> stopsInLines = new ArrayList<>();

        LineResponseOfPwsResult lineResponseData = (LineResponseOfPwsResult) completableFutureLine.join();

        if(lineResponseData.getStatusCode() != 0){
            throw new RuntimeException("Error in API call : https://api.sl.se/api2/LineData.json?model=JourneyPatternPointOnLine Api returned with status:  "+lineResponseData.getStatusCode()+"Message: "+lineResponseData.getMessage() );
        }

        Map<String, List<LineResult>> lineResultMap = getlineResultIntoMap(lineResponseData);

        List<String> longList = getListOfLinesWithMostStops(lineResultMap);

        StopResponseOfPwsResult stopResponseData = (StopResponseOfPwsResult) completableFutureStop.join();

        if(stopResponseData.getStatusCode() != 0){
            throw new RuntimeException("Error in API call : https://api.sl.se/api2/LineData.json?model=stop, Api returned with status:  "+lineResponseData.getStatusCode()+"Message: "+lineResponseData.getMessage() );
        }

        Map<String, String> stopResponseMap = mapStopPointNameAgainstNo(stopResponseData);

        longList.forEach((key) -> {
            StopsInLine stopsInLine = new StopsInLine();
            stopsInLine.setLineNo(key);
            Set<String> stopNameList = new HashSet<>();
            stopsInLine.setStopNameList(stopNameList);
            lineResultMap.get(key).stream().map((value) -> value.getJourneyPatternPointNumber()).forEach((stopPoint) -> {
                        stopNameList.add(stopResponseMap.get(stopPoint));
                    }
            );
            stopsInLines.add(stopsInLine);
        });

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("CET"));
        String lineUpdatedDate = lineResponseData.getResponseData().getVersion()+":00";
        String stopResponseDate = stopResponseData.getResponseData().getVersion()+":00";

        ResponseBusStop responseBusStop = new ResponseBusStop();
        responseBusStop.setLastUpdatedDateStop(dateFormat.parse(stopResponseDate));
        responseBusStop.setLastUpdatedDateLine(dateFormat.parse(lineUpdatedDate));
        responseBusStop.setStopsInLine(stopsInLines);

        return responseBusStop;
    }

}


