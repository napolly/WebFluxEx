package com.example.HJWebFlux.collector.repository;
import com.example.HJWebFlux.collector.Entity.LinkSpeedEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface LinkSpeedRepository extends ReactiveCrudRepository<LinkSpeedEntity, Long> {
}

