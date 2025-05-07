package br.ifsp.edu.br.Avaliacao02.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleInfo {
    private String vehMake;
    private String vehModel;
    private String vehYear;
    private String vehColor;
}