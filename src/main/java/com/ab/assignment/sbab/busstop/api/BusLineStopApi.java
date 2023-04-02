package com.ab.assignment.sbab.busstop.api;

import com.ab.assignment.sbab.busstop.model.response.ResponseBusStop;
import com.ab.assignment.sbab.busstop.model.response.StopsInLine;
import com.ab.assignment.sbab.busstop.service.CommonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebServerApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.ExecutionException;

@Slf4j
@RestController
public class BusLineStopApi {

    @Autowired
    AnnotationConfigReactiveWebServerApplicationContext context;
    @Autowired
    CommonService commonService;

    @Autowired
    ResponseBusStop responseBusStop;

    @RequestMapping(value = "/getBusTops", method = RequestMethod.GET)
    public ResponseEntity<List<StopsInLine>> getBusStops() throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setTimeZone(TimeZone.getTimeZone("CET"));
        String curDate = dateFormat.format(new Date());
        String lineResponseDate = dateFormat.format(responseBusStop.getLastUpdatedDateLine());
        String stopResponseDate = dateFormat.format(responseBusStop.getLastUpdatedDateStop());

        try {
            if (curDate.equals(lineResponseDate) && curDate.equals(stopResponseDate)) {

                return  ResponseEntity.ok().body(responseBusStop.getStopsInLine());

            } else {
                ResponseBusStop responseBusStop = commonService.getFinalResult();
                context.removeBeanDefinition("cache");
                context.registerBean("cache", ResponseBusStop.class, () -> responseBusStop);
                return  ResponseEntity.ok().body(responseBusStop.getStopsInLine());
            }
        }catch(Exception ex){
            log.info(ex.getMessage());
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }

}
