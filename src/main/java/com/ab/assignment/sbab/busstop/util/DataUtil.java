package com.ab.assignment.sbab.busstop.util;

import com.ab.assignment.sbab.busstop.model.line.LineResponseOfPwsResult;
import com.ab.assignment.sbab.busstop.model.line.LineResult;
import com.ab.assignment.sbab.busstop.model.stop.StopResponseOfPwsResult;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class DataUtil {
    public static Map<String, List<LineResult>> getlineResultIntoMap(LineResponseOfPwsResult lineResponseData) {

        return lineResponseData.getResponseData()
                .getResult()
                .parallelStream()
                .collect(Collectors.groupingBy((res) -> res.getLineNumber(), Collectors.toList()));

    }

    public static List<String> getListOfLinesWithMostStops(Map<String, List<LineResult>> lineResultMap) {
        return lineResultMap.keySet()
                .parallelStream()
                .sorted((key1, key2) -> lineResultMap.get(key2).size() - lineResultMap.get(key1).size())
                .limit(10).collect(Collectors.toList());
    }

    public static Map<String, String> mapStopPointNameAgainstNo(StopResponseOfPwsResult stopResponseData) {
        return stopResponseData.getResponseData()
                .getResult()
                .parallelStream()
                .collect(Collectors.toMap((key) -> key.getStopPointNumber(), (val) -> val.getStopPointName()));
    }
}
