package br.ifsp.edu.br.Avaliacao02.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "repairs")
@Getter
@NoArgsConstructor
public class RepairJob {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "entry_date", nullable = false)
    private String entryDate;

    @Column(name = "exit_date")
    private String exitDate;

    @Embedded
    private MechanicInfo mechanic;

    @Embedded
    private VehicleInfo vehicle;

    @Column(nullable = false)
    private boolean active = true;

    public RepairJob(String entryDate,
                     String exitDate,
                     MechanicInfo mechanic,
                     VehicleInfo vehicle) {
        this.entryDate = entryDate;
        this.exitDate  = exitDate;
        this.mechanic  = mechanic;
        this.vehicle   = vehicle;
    }

    public void updateExit(String exitDate, MechanicInfo mechanic) {
        if (exitDate != null)    this.exitDate = exitDate;
        if (mechanic != null)    this.mechanic = mechanic;
    }

    public void deactivate() {
        this.active = false;
    }
}