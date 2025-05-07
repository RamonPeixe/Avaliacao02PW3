package br.ifsp.edu.br.Avaliacao02.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record MechanicData(
        @NotBlank String mechName,
        @Min(0)    int    mechYears
) {}