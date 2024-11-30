package com.example.HJWebFlux.collector.Entity;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("its_link_speed")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinkSpeedEntity {
    @Id
    private Long id; // 자동 생성 ID
    private String roadName;
    private String linkId;
    private String startNodeId;
    private String endNodeId;
    private Integer speed;
    private Double travelTime;
    private String createdDate;
}

