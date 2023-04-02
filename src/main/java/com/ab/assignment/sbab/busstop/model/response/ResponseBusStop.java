package com.ab.assignment.sbab.busstop.model.response;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ResponseBusStop {
    Date lastUpdatedDateLine;
    Date lastUpdatedDateStop;
    List<StopsInLine> stopsInLine;

}
