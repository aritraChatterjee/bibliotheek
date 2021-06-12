package com.bibliotheek.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Schema(name = "AuthorJson")
public class AuthorDto {
    @Schema(description = "First name of the author.", example = "Rudyard", required = true)
    private String firstName;

    @Schema(description = "Last name of the author.", example = "Kipling", required = true)
    private String lastName;
}
