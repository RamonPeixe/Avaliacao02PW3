package br.ifsp.edu.br.Avaliacao02.dto;

import jakarta.validation.constraints.Pattern;

public record RepairUpdateRequest(
        @Pattern(regexp="\\d{2}/\\d{2}/\\d{4}") String exitDate,
        String mechName,
        Integer mechYears
) {}