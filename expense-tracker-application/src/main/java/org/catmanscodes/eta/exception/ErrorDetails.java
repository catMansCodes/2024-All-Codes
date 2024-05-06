package org.catmanscodes.eta.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Schema(
        description = "Error Details for API Errors"
)
@Getter
@Setter
public class ErrorDetails {

    @Schema(description = "Error occurred Date and Time")
    private LocalDateTime timestamp;

    @Schema(description = "Error message")
    private String message;

    @Schema(description = "Error details")
    private String details;

    @Schema(description = "Error code")
    private String errorCode;
}
