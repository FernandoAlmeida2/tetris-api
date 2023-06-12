package com.api.tetrisapi.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ResultRecordDto(@NotBlank String name, @NotNull int score, @NotNull int speed) {
}
