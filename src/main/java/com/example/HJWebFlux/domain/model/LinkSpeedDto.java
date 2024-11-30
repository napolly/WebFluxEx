package com.example.HJWebFlux.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinkSpeedDto {
    private String roadName;
    private String linkId;
    private String startNodeId;
    private String endNodeId;
    private Integer speed;
    private Double travelTime;
    private String createdDate;
}
