package com.Proyecto_Sena.Efi_Entregas.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class ConexOrdenPlanTrabajo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConexOrdenPlanTrabajo;

    @ManyToOne
    @JoinColumn(name = "idPlanTrabajo", nullable = false)
    private PlanTrabajo planTrabajo;

    @ManyToOne
    @JoinColumn(name = "idOrden", nullable = false)
    private OrdenEnvio ordenEnvio;

    @Column(nullable = false, updatable = false)
    private LocalDateTime fechaCreacion;

    @PrePersist
    protected void onCreate() {
        this.fechaCreacion = LocalDateTime.now();
    }

}
