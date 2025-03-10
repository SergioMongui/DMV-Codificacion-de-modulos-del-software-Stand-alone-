package com.Proyecto_Sena.Efi_Entregas.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class PlanTrabajo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPlanTrabajo;

    @Column(nullable = false)
    private String estadoPT;
}
