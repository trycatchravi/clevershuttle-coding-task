package com.org.clevershuttlecodingtask.rest.dto;

import com.org.clevershuttlecodingtask.domain.model.Status;

import java.time.Instant;

public record CarDto(Long id, String brand, String licensePlate, String manufacturer, String operationCity,
                     Status status, Instant createdAt, Instant lastUpdatedAt) {
}
