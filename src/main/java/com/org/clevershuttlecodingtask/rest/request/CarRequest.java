package com.org.clevershuttlecodingtask.rest.request;

import com.org.clevershuttlecodingtask.domain.model.Status;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;

public record CarRequest(@NotBlank String brand, @NotBlank String licensePlate, @NotBlank String manufacturer, @NotBlank String operationCity,
                         @NotNull Status status, Instant createdAt, Instant lastUpdatedAt) {
}
