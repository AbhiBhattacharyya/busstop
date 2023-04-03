package service;

import com.ab.assignment.sbab.busstop.BusstopApplication;
import com.ab.assignment.sbab.busstop.model.response.ResponseBusStop;
import com.ab.assignment.sbab.busstop.service.CommonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebServerApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

@SpringBootTest(classes ={ BusstopApplication.class,AnnotationConfigReactiveWebServerApplicationContext.class})
public class CommonServiceTest {

    @Autowired
    CommonService commonService;

    @Test
    public void testGetFinalResult() throws ParseException {
        ResponseBusStop responseBusStop =  commonService.getFinalResult();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateNow = new Date();
        String todayDate = simpleDateFormat.format(dateNow);
        String lastUpdatedDateStop = simpleDateFormat.format(responseBusStop.getLastUpdatedDateStop());
        String lastUpdatedDateLine = simpleDateFormat.format(responseBusStop.getLastUpdatedDateLine());
        assertNotNull(responseBusStop);
        assertEquals(10,responseBusStop.getStopsInLine().size());
        assertEquals(todayDate,lastUpdatedDateStop);
        assertEquals(todayDate,lastUpdatedDateLine);
    }

}
