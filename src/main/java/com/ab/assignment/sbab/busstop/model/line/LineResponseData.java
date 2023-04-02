package com.ab.assignment.sbab.busstop.model.line;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Version",
        "Type",
        "Result"
})
@Data
public class LineResponseData {

    @JsonProperty("Version")
    private String version;
    @JsonProperty("Type")
    private String type;
    @JsonProperty("Result")
    private List<LineResult> result;

}
