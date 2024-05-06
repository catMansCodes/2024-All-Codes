package org.catmanscodes.eta.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        description = "Category DTO -Data Transfer Object to transfer data between clint & server"
)
public record CategoryDto(

        Long id,
        @Schema(
                description = "Category Name"
        )
        String name
) {
}
