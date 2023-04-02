package com.ab.assignment.sbab.busstop.model.response;

import lombok.Data;

import java.util.Set;

@Data
public class StopsInLine {
    private String lineNo;
    private Set<String> stopNameList;
}
