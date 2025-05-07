package br.ifsp.edu.br.Avaliacao02.dto;

import br.ifsp.edu.br.Avaliacao02.model.RepairJob;

public record RepairDetail(
        Long            id,
        String          entryDate,
        String          exitDate,
        MechanicData    mechanic,
        VehicleData     vehicle,
        boolean         active
) {
    public RepairDetail(RepairJob r) {
        this(
                r.getId(),
                r.getEntryDate(),
                r.getExitDate(),
                new MechanicData(r.getMechanic().getMechName(), r.getMechanic().getMechYears()),
                new VehicleData(
                        r.getVehicle().getVehMake(),
                        r.getVehicle().getVehModel(),
                        r.getVehicle().getVehYear(),
                        r.getVehicle().getVehColor()
                ),
                r.isActive()
        );
    }
}