package br.ifsp.edu.br.Avaliacao02.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record RepairRequest(
        @NotBlank @Pattern(regexp="\\d{2}/\\d{2}/\\d{4}") String entryDate,
        @Pattern(regexp="\\d{2}/\\d{2}/\\d{4}")            String exitDate,
        @Valid MechanicData  mechanic,
        @Valid VehicleData   vehicle
) {}