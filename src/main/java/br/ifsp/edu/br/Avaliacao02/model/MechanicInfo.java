package br.ifsp.edu.br.Avaliacao02.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MechanicInfo {
    private String mechName;
    private int    mechYears;
}