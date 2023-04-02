package com.ab.assignment.sbab.busstop.model.stop;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "StopPointNumber",
        "StopPointName",
        "StopAreaNumber",
        "LocationNorthingCoordinate",
        "LocationEastingCoordinate",
        "ZoneShortName",
        "StopAreaTypeCode",
        "LastModifiedUtcDateTime",
        "ExistsFromDate"
})
@Data
public class StopResult {

    @JsonProperty("StopPointNumber")
    private String stopPointNumber;
    @JsonProperty("StopPointName")
    private String stopPointName;
    @JsonProperty("StopAreaNumber")
    private String stopAreaNumber;
    @JsonProperty("LocationNorthingCoordinate")
    private String locationNorthingCoordinate;
    @JsonProperty("LocationEastingCoordinate")
    private String locationEastingCoordinate;
    @JsonProperty("ZoneShortName")
    private String zoneShortName;
    @JsonProperty("StopAreaTypeCode")
    private String stopAreaTypeCode;
    @JsonProperty("LastModifiedUtcDateTime")
    private String LastModifiedUtcDateTime;
    @JsonProperty("ExistsFromDate")
    private String ExistsFromDate;

}
