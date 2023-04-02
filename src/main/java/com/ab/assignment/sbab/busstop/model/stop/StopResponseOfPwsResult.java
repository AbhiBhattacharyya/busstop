package com.ab.assignment.sbab.busstop.model.stop;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "StatusCode",
        "Message",
        "ExecutionTime",
        "ResponseData"
})
@Data
public class StopResponseOfPwsResult {

    @JsonProperty("StatusCode")
    private Integer statusCode;
    @JsonProperty("Message")
    private Object message;
    @JsonProperty("ExecutionTime")
    private Integer executionTime;
    @JsonProperty("ResponseData")
    private StopResponseData responseData;

}
