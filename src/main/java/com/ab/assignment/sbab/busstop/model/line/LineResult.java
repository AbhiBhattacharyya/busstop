package com.ab.assignment.sbab.busstop.model.line;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "LineNumber",
        "DirectionCode",
        "JourneyPatternPointNumber",
        "LastModifiedUtcDateTime",
        "ExistsFromDate"
})
@Data
public class LineResult {

    @JsonProperty("LineNumber")
    private String lineNumber;
    @JsonProperty("DirectionCode")
    private String directionCode;
    @JsonProperty("JourneyPatternPointNumber")
    private String journeyPatternPointNumber;
    @JsonProperty("LastModifiedUtcDateTime")
    private String lastModifiedUtcDateTime;
    @JsonProperty("ExistsFromDate")
    private String existsFromDate;

}
