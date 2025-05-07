package br.ifsp.edu.br.Avaliacao02.dto;

import br.ifsp.edu.br.Avaliacao02.model.RepairJob;

public record RepairSummary(
        Long   id,
        String entryDate,
        String exitDate,
        String mechName,
        String vehMake,
        String vehModel
) {
    public RepairSummary(RepairJob r) {
        this(
                r.getId(),
                r.getEntryDate(),
                r.getExitDate(),
                r.getMechanic().getMechName(),
                r.getVehicle().getVehMake(),
                r.getVehicle().getVehModel()
        );
    }
}