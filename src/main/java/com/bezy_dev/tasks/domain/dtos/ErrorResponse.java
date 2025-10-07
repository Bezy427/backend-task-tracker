package com.bezy_dev.tasks.domain.dtos;

public record ErrorResponse(
        int status,
        String message,
        String details
) {

}
