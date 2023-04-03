package api;

import com.ab.assignment.sbab.busstop.BusstopApplication;
import com.ab.assignment.sbab.busstop.api.BusLineStopApi;
import com.ab.assignment.sbab.busstop.model.response.StopsInLine;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebServerApplicationContext;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest(classes ={ BusstopApplication.class,AnnotationConfigReactiveWebServerApplicationContext.class})
public class BusLineStopApiTest {

    @Autowired
    BusLineStopApi busLineStopApi;

    @Test
    public void getBusStopsTest() throws ParseException {

      ResponseEntity<List<StopsInLine>> response = busLineStopApi.getBusStops();
        HttpStatusCode httpStatusCode = response.getStatusCode();
        assertEquals(10,response.getBody().size());
        assertEquals(200,httpStatusCode.value());

    }

}
