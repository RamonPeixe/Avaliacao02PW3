package br.ifsp.edu.br.Avaliacao02.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record VehicleData(
        @NotBlank String vehMake,
        @NotBlank String vehModel,
        @NotBlank @Pattern(regexp="\\d{4}") String vehYear,
        String vehColor
) {}